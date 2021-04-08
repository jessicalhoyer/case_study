package com.scribe.jessica.hoyer.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;

import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.FolderRepository;
import com.scribe.jessica.hoyer.services.FolderService;

public class FolderServiceTest {
	private static FolderService folderService;
	private static FolderRepository folderRepository;
	
	@BeforeClass
	public static void setUp() {
		folderRepository = Mockito.mock(FolderRepository.class);
		folderService = new FolderService(folderRepository);
	}
	
	@Test
	public void testListAllFolders() {
		User user = new User();
		user.setId(1);
		Folder f1 = new Folder();
		Folder f2 = new Folder();
		f1.setUser(user);
		f2.setUser(user);
		
		List<Folder> list = new ArrayList<>();
		list.add(f1);
		list.add(f2);
		Mockito.when(folderRepository.findByUserId(1)).thenReturn(list);
		List<Folder> actual = folderService.listAllFolders(1);
		int expected = 2;
		assertEquals(expected, actual.size());
	}
	
	@Test
	public void testFindById() {
		Folder folder = new Folder("titleTest", null);
		User user = new User();
		folder.setId(1);
		folder.setUser(user);
		Mockito.when(folderRepository.findById(anyInt())).thenReturn(folder);
		Folder actual = folderService.findById(1);
		int expected = 1;
		assertEquals(expected, actual.getId());
	}
	
	@Test
	public void editFolder() {
		Mockito.when(folderRepository.editFolder(anyString(), anyInt())).thenReturn(true);
		assertTrue(folderService.editFolder_test("test", 1));
	}

}
