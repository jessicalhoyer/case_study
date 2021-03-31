package com.scribe.jessica.hoyer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.repositories.FolderRepository;
import com.scribe.jessica.hoyer.repositories.U_DirectoryRepository;

@Service
public class U_DirectoryService {
	private U_DirectoryRepository repo;
	
	@Autowired
	public U_DirectoryService(U_DirectoryRepository repo) {
		this.repo = repo;
	}
	
	public List<Document> listDocByFolder(int id) {
		return (List<Document>) repo.findByFolders(id);
	}

}
