package com.scribe.jessica.hoyer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.models.User;
import com.scribe.jessica.hoyer.repositories.FolderRepository;
import com.scribe.jessica.hoyer.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private FolderRepository folderRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<Folder> listAllFolders() {
		return (List<Folder>) folderRepository.findByUserId();
	}

}
