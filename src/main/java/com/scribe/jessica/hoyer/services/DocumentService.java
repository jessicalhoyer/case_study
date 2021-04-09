package com.scribe.jessica.hoyer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.repositories.DocumentRepository;

@Service
public class DocumentService {
	private DocumentRepository documentRepository;
	
	@Autowired
	public DocumentService(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}
	
	// save documents
	public void saveDocument(Document doc) {
		documentRepository.save(doc);
	}
	
	// list all documents
	public List<Document> listAllDocuments() {
		return (List<Document>) documentRepository.findAll();
	}
	
	// list all documents with a certain folder id
	public List<Document> listAllDocsByFolderId(int id) {
		return (List<Document>) documentRepository.findByFolderId(id);
	}
	
	// find a document by id
	public Document findById(int id) {
		return documentRepository.findById(id);
	}
	
	// edit a document's title, content, and folder using its id
	public void editDocument(String title, String content, Folder folder, int id) {
		documentRepository.editDocument(title, content, folder, id);
	}
	
	// delete document by id
	public void deleteDocument(int id) {
		documentRepository.deleteById(id);
	}

}
