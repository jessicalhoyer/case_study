package com.scribe.jessica.hoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribe.jessica.hoyer.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
