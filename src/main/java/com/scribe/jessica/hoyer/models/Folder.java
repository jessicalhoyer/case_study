package com.scribe.jessica.hoyer.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "folder")
public class Folder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="title", nullable=false)
	@NotBlank(message="Title cannot be blank")
	private String title;
	
	@OneToMany(mappedBy = "folder", fetch = FetchType.EAGER)
	private List<Document> documents;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Folder() {
		super();
	}
	
	public Folder(String title, List<Document> documents) {
		super();
		this.title = title;
		this.documents = documents;
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

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Folder [id=" + id + ", title=" + title + ", documents=" + documents + ", user=" + user + "]";
	}

}
