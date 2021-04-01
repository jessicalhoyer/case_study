package com.scribe.jessica.hoyer.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Folder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@OneToMany(targetEntity = Document.class)
	private List<String> documents;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	Folder() {
		super();
	}
	
	public Folder(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
