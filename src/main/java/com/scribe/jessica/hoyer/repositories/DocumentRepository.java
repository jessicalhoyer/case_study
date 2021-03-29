package com.scribe.jessica.hoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribe.jessica.hoyer.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
