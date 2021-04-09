package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scribe.jessica.hoyer.models.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

	// find folder by id
	public Folder findById(int id);
	
	// list all folders by user id
	public List<Folder> findByUserId(int id);
	
	// edit folder's title using its id
	@Transactional
	@Modifying
	@Query("UPDATE Folder f SET f.title = :new_title WHERE f.id = :id")
	public void editFolder(@Param("new_title") String title,
			@Param("id") int id);
	
	// delete folder by id
	public void deleteById(int id);

}
