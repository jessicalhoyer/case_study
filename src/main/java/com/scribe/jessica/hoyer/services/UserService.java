package com.scribe.jessica.hoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribe.jessica.hoyer.exceptions.UsernameTakenException;
import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// save user
	// throws exception if user tries to use a username that's already taken
	public void saveUser(User user) throws UsernameTakenException {
		try {
			userRepository.save(user);
		}
		catch (Exception e) {
			throw new UsernameTakenException("Username already taken");
		}
	}
	
	// find user by username
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	// delete user
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	// edits user's username and password using its id
	// throws exception if user tries to use a username that's already taken
	public void editProfile(String username, String password, int id) throws UsernameTakenException {
		try {
			userRepository.editProfile(username, password, id);
		}
		catch (Exception e) {
			throw new UsernameTakenException("Username already taken");
		}
	}

}
