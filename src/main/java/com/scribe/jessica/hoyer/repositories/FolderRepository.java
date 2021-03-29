package com.scribe.jessica.hoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribe.jessica.hoyer.models.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

}
