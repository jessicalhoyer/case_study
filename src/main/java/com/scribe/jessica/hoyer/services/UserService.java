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
	
	public void saveUser(User user) throws UsernameTakenException {
		try {
			userRepository.save(user);
		}
		catch (Exception e) {
			throw new UsernameTakenException("Username already taken");
		}
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public void editProfile(String username, String password, int id) throws UsernameTakenException {
		try {
			userRepository.editProfile(username, password, id);
		}
		catch (Exception e) {
			throw new UsernameTakenException("Username already taken");
		}
	}
	
	public boolean editProfile_test(String username, String password, int id) {
		if (userRepository.editProfile(username, password, id)) {
			return true;
		}
		else {
			return false;
		}
	}

}
