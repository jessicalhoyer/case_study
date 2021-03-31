package com.scribe.jessica.hoyer.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class U_Directory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@OneToMany(targetEntity = User.class)
//	@JoinColumn(name="user_id")
	private List<User> users;
	
	@OneToMany(targetEntity = Document.class)
//	@JoinColumn(name="doc_id")
	private List<Document> documents;
	
	@OneToMany(targetEntity = Folder.class)
//	@JoinColumn(name="folder_id")
	private List<Folder> folders;

}
