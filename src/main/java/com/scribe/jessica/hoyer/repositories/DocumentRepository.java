package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribe.jessica.hoyer.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
	
	// find by documents by username and folder id
	
	public List<Document> findByFolderId(int id);
	
	public Document findById(int id);

}
