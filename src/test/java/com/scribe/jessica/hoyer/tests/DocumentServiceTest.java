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
	
	@BeforeClass
	public static void setUp() {
		documentRepository = Mockito.mock(DocumentRepository.class);
		documentService = new DocumentService(documentRepository);
	}
	
	@Test
	public void testListAllDocuments() {
		User user = new User();
		user.setId(1);
		Folder folder = new Folder();
		folder.setUser(user);
		
		Document doc1 = new Document();
		Document doc2 = new Document();
		doc1.setFold(folder);
		doc2.setFold(folder);
		
		List<Document> list = new ArrayList<>();
		list.add(doc1);
		list.add(doc2);
		Mockito.when(documentRepository.findAll()).thenReturn(list);
		List<Document> actual = documentService.listAllDocuments();
		int expected = 2;
		assertEquals(expected, actual.size());
	}
	
	@Test
	public void testListAllDocumentsByFolderId() {
		User user = new User();
		user.setId(1);
		Folder folder = new Folder();
		folder.setId(1);
		folder.setUser(user);
		
		Document doc1 = new Document();
		Document doc2 = new Document();
		doc1.setFold(folder);
		doc2.setFold(folder);
		
		List<Document> list = new ArrayList<>();
		list.add(doc1);
		list.add(doc2);
		Mockito.when(documentRepository.findByFolderId(anyInt())).thenReturn(list);
		List<Document> actual = documentService.listAllDocsByFolderId(folder.getId());
		int expected = 2;
		assertEquals(expected, actual.size());
	}
	
	@Test
	public void testFindById() {
		Document doc = new Document("titleTest", "contentTest");
		User user = new User();
		user.setId(1);
		Folder folder = new Folder();
		folder.setId(1);
		folder.setUser(user);
		doc.setFold(folder);
		doc.setId(1);
		
		Mockito.when(documentRepository.findById(anyInt())).thenReturn(doc);
		Document actual = documentService.findById(1);
		int expected = 1;
		assertEquals(expected, actual.getId());
	}

}
