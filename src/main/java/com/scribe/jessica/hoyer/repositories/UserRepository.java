package com.scribe.jessica.hoyer.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scribe.jessica.hoyer.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// find user by username
	public User findByUsername(String username);
	
	// delete user
	public void deleteById(int id);
	
	// edits user's username and password using its id
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.username = :new_username, u.password = :new_password"
			+"  WHERE u.id = :id")
	public void editProfile(@Param("new_username") String username,
			@Param("new_password") String password,
			@Param("id") int id);
	
}
