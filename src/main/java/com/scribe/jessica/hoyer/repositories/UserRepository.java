package com.scribe.jessica.hoyer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scribe.jessica.hoyer.models.Document;
import com.scribe.jessica.hoyer.models.Folder;
import com.scribe.jessica.hoyer.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
	
//	@Query("SELECT f FROM Folder f WHERE f.user_id = :u_id")
//	List<Folder> findById(@Param("u_id") String username);
//	
//	List<Document> findByIdAndFolderId(int u_id, int f_id);
}
