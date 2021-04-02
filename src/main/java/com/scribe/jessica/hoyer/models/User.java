package com.scribe.jessica.hoyer.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="username", length=50, nullable=false, unique=true)
	@Size(min = 2, max = 50, message="Username must be between 2 and 50 characters")
	@NotBlank
	private String username;
	
	@Column(name="password", length=50, nullable=false)
	@Size(min = 4, max = 20, message="Password must be between 4 and 20 characters")
	@NotBlank
	private String password;
	
	@OneToMany(targetEntity = Folder.class)
	private List<Folder> folders;
	
	public User() {
		super();
	}
	
	public User(String username, String password, List<Folder> folders) {
		super();
		this.username = username;
		this.password = password;
		this.folders = folders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}
	
	

}