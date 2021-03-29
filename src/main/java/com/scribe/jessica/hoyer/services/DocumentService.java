package com.scribe.jessica.hoyer.services;

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

}
