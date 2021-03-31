package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribe.jessica.hoyer.models.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

	List<Folder> findByUserId(int id);

}
