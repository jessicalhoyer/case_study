package com.scribe.jessica.hoyer.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyString;
import static org.junit.Assert.assertEquals;

import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.UserRepository;
import com.scribe.jessica.hoyer.services.UserService;

public class UserServiceTest {
	private static UserService userService;
	private static UserRepository userRepository;

	// set up a mock instance of UserRepository and UserService
	@BeforeClass
	public static void setUp() {
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserService(userRepository);
	}
	
	// test findByUsername method
	@Test
	public void testFindByUsername() {
		// pass a test user object to be returned by the method
		// check to make sure that the password returned by that method matches the
		// expected password
		Mockito.when(userRepository.findByUsername(anyString())).thenReturn(new User("testUser1", "testPass1", null));
		User actual = userService.findByUsername("testUser1");
		String expected = "testPass1";
		assertEquals(expected, actual.getPassword());
	}

}
