package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.models.U_Directory;

public interface U_DirectoryRepository extends JpaRepository<U_Directory, Integer> {
	
	public List<Document> findByFolders(int id);

}
