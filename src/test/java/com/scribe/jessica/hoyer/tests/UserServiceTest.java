package com.scribe.jessica.hoyer.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyObject;

import com.scribe.jessica.hoyer.exceptions.UsernameTakenException;
import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.UserRepository;
import com.scribe.jessica.hoyer.services.UserService;

public class UserServiceTest {
	private static UserService userService;
	private static UserRepository userRepository;

	@BeforeClass
	public static void setUp() {
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserService(userRepository);
	}
	
	@Test
	public void testSaveUser() {
		Mockito.when(userRepository.save(anyObject())).thenReturn(new User("testUser1", "testPass1", null));
		User actual = userService.saveUser_testing(new User());
		User expected = new User("testUser1", "testPass1", null);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindByUsername() {
		Mockito.when(userRepository.findByUsername(anyString())).thenReturn(new User("testUser1", "testPass1", null));
		User actual = userService.findByUsername("testUser1");
		String expected = "testPass1";
		assertEquals(expected, actual.getPassword());
	}
	
	@Test
	public void testDeleteUser() {
		
	}
	
	@Test
	public void testEditProfile() {
		
	}

}
