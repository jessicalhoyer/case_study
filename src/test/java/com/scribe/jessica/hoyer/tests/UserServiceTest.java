package com.scribe.jessica.hoyer.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.anyInt;

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

	}
	
	@Test
	public void testFindByUsername() {
		Mockito.when(userRepository.findByUsername(anyString())).thenReturn(new User("testUser1", "testPass1", null));
		User actual = userService.findByUsername("testUser1");
		String expected = "testPass1";
		assertEquals(expected, actual.getPassword());
	}
	
	public void testDeleteUser() {
		
	}
	
	@Test
	public void testEditProfile() {
		Mockito.when(userRepository.editProfile(anyString(), anyString(), anyInt())).thenReturn(true);
		assertTrue(userService.editProfile_test("test", "test", 1));
	}

}
