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
	
	public void saveFolder(Folder folder) {
		folderRepository.save(folder);
	}
	
	public List<Folder> listAllFolders(int id) {
		return (List<Folder>) folderRepository.findByUserId(id);
	}
	
	public Folder findById(int id) {
		return folderRepository.findById(id);
	}
	
	public void editFolder(String title, int id) {
		folderRepository.editFolder(title, id);
	}
	
	public boolean editFolder_test(String title, int id) {
		if (folderRepository.editFolder(title, id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void deleteFolder(int id) {
		folderRepository.deleteById(id);
	}

}
