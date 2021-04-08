package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scribe.jessica.hoyer.models.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

	public Folder findById(int id);
	
	public List<Folder> findByUserId(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Folder f SET f.title = :new_title WHERE f.id = :id")
	public boolean editFolder(@Param("new_title") String title,
			@Param("id") int id);
	// changed to boolean
	
	public void deleteById(int id);

}
