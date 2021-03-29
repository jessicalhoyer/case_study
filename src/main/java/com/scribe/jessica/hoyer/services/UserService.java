package com.scribe.jessica.hoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserService() {}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public boolean loginUser(User user) {
		User uFound = userRepository.findByUsername(user.getUsername());
		if (uFound.getPassword().equals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}

}
