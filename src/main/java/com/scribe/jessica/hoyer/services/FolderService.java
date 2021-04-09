package com.scribe.jessica.hoyer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.repositories.FolderRepository;

@Service
public class FolderService {
	private FolderRepository folderRepository;
	
	@Autowired
	public FolderService(FolderRepository folderRepository) {
		this.folderRepository = folderRepository;
	}
	
	// save folder
	public void saveFolder(Folder folder) {
		folderRepository.save(folder);
	}
	
	// list all folders by using id
	public List<Folder> listAllFolders(int id) {
		return (List<Folder>) folderRepository.findByUserId(id);
	}
	
	// find folder by id
	public Folder findById(int id) {
		return folderRepository.findById(id);
	}
	
	// edit a folder's title using its id
	public void editFolder(String title, int id) {
		folderRepository.editFolder(title, id);
	}
	
	// delete folder by id
	public void deleteFolder(int id) {
		folderRepository.deleteById(id);
	}

}
