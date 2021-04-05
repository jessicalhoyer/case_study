package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scribe.jessica.hoyer.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
	
	public List<Document> findByFolderId(int id);
	
	public Document findById(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Document d SET d.title = :new_title, d.content = :new_content"
			+ " WHERE d.id = :id")
	public void editDocument(@Param("new_title") String title,
			@Param("new_content") String content,
			@Param("id") int id);
	
	public void deleteById(int id);
	
//	public void saveDocumentById(int id);

}
