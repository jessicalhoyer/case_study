package com.scribe.jessica.hoyer.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyInt;

import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.FolderRepository;
import com.scribe.jessica.hoyer.services.FolderService;

public class FolderServiceTest {
	private static FolderService folderService;
	private static FolderRepository folderRepository;
	
	// set up a mock instance of FolderRepository and FolderService
	@BeforeClass
	public static void setUp() {
		folderRepository = Mockito.mock(FolderRepository.class);
		folderService = new FolderService(folderRepository);
	}
	
	// testing listAllFolders method
	@Test
	public void testListAllFolders() {
		// set up test user and two test folders
		// set test user as the owner of both folders
		User user = new User();
		user.setId(1);
		Folder f1 = new Folder();
		Folder f2 = new Folder();
		f1.setUser(user);
		f2.setUser(user);
		
		// create an empty folder ArrayList
		// add test folders to it
		// test to see that the length of the test document list returned from the method
		// matches the expected length
		List<Folder> list = new ArrayList<>();
		list.add(f1);
		list.add(f2);
		Mockito.when(folderRepository.findByUserId(anyInt())).thenReturn(list);
		List<Folder> actual = folderService.listAllFolders(1);
		int expected = 2;
		assertEquals(expected, actual.size());
	}
	
	// test findById method
	@Test
	public void testFindById() {
		// set up test folder
		// set up test user
		// set test folder id to 1
		// set the test user as the owner of the test folder
		Folder folder = new Folder("titleTest", null);
		User user = new User();
		folder.setId(1);
		folder.setUser(user);
		
		// check that the id number returned from the method matches the id number provided
		Mockito.when(folderRepository.findById(anyInt())).thenReturn(folder);
		Folder actual = folderService.findById(1);
		int expected = 1;
		assertEquals(expected, actual.getId());
	}

}
