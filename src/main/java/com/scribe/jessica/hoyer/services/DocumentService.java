package com.scribe.jessica.hoyer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.repositories.DocumentRepository;

@Service
public class DocumentService {
	private DocumentRepository documentRepository;
	
	@Autowired
	public DocumentService(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}
	
	public void saveDocument(Document doc) {
		documentRepository.save(doc);
	}
	
	public List<Document> listAllDocuments() {
		return (List<Document>) documentRepository.findAll();
	}
	
	public List<Document> listAllDocsByFolderId(int id) {
		return (List<Document>) documentRepository.findByFolderId(id);
	}
	
	public Document findById(int id) {
		return documentRepository.findById(id);
	}
	
	public void editDocument(String title, String content, int id) {
		documentRepository.editDocument(title, content, id);
	}
	
	public void deleteDocument(int id) {
		documentRepository.deleteById(id);
	}

}
