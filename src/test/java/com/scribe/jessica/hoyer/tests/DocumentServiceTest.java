package com.scribe.jessica.hoyer.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.DocumentRepository;
import com.scribe.jessica.hoyer.services.DocumentService;

import static org.mockito.Mockito.anyString;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyInt;

public class DocumentServiceTest {
	private static DocumentService documentService;
	private static DocumentRepository documentRepository;
	
	// set up a mock instance of DocumentRepository and DocumentService
	@BeforeClass
	public static void setUp() {
		documentRepository = Mockito.mock(DocumentRepository.class);
		documentService = new DocumentService(documentRepository);
	}
	
	// testing listAllDocuments method
	@Test
	public void testListAllDocuments() {
		// set up a test user instance and test folder instance
		// set the test user as the owner of the test folder
		User user = new User();
		user.setId(1);
		Folder folder = new Folder();
		folder.setUser(user);
		
		// set up two test document instances
		Document doc1 = new Document();
		Document doc2 = new Document();
		doc1.setFold(folder);
		doc2.setFold(folder);
		
		// create an empty document ArrayList
		// add test documents to it
		// test to see that length of the test document list returned from the method
		// matches the expected length
		List<Document> list = new ArrayList<>();
		list.add(doc1);
		list.add(doc2);
		Mockito.when(documentRepository.findAll()).thenReturn(list);
		List<Document> actual = documentService.listAllDocuments();
		int expected = 2;
		assertEquals(expected, actual.size());
	}
	
	// test listAllDocumentsByFolderId method
	@Test
	public void testListAllDocumentsByFolderId() {
		// set up test user instance and test folder instance
		// set the test folder id to 1
		// set the test user as the owner of the test folder
		User user = new User();
		user.setId(1);
		Folder folder = new Folder();
		folder.setId(1);
		folder.setUser(user);
		
		// set up two test document instances
		// set their folders to the test folder
		Document doc1 = new Document();
		Document doc2 = new Document();
		doc1.setFold(folder);
		doc2.setFold(folder);
		
		// create an empty document ArrayList
		// add test documents to it
		// test to see that length of the test document list returned matches the length
		// provided by the method
		List<Document> list = new ArrayList<>();
		list.add(doc1);
		list.add(doc2);
		Mockito.when(documentRepository.findByFolderId(anyInt())).thenReturn(list);
		List<Document> actual = documentService.listAllDocsByFolderId(folder.getId());
		int expected = 2;
		assertEquals(expected, actual.size());
	}
	
	// test findById method
	@Test
	public void testFindById() {
		// set up test document, test user, and test folder
		// set test user id to 1
		// set test user as the owner of the test folder
		// set the test folder as containing the test document
		Document doc = new Document("titleTest", "contentTest");
		User user = new User();
		user.setId(1);
		Folder folder = new Folder();
		folder.setId(1);
		folder.setUser(user);
		doc.setFold(folder);
		doc.setId(1);
		
		// check to see that the document returned from the method has the same id number
		// as the number expected
		Mockito.when(documentRepository.findById(anyInt())).thenReturn(doc);
		Document actual = documentService.findById(1);
		int expected = 1;
		assertEquals(expected, actual.getId());
	}

}
