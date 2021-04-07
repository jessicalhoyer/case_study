package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.models.Folder;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
	
	public List<Document> findByFolderId(int id);
	
	public Document findById(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Document d SET d.title = :new_title, d.content = :new_content"
			+ ", d.folder = :new_folder WHERE d.id = :id")
	public void editDocument(@Param("new_title") String title,
			@Param("new_content") String content,
			@Param("new_folder") Folder folder,
			@Param("id") int id);
	
	public void deleteById(int id);
	
//	public void saveDocumentById(int id);

}
