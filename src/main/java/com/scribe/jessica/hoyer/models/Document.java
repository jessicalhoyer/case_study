package com.scribe.jessica.hoyer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "document")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="title", nullable=false)
	@NotBlank(message="Title cannot be blank")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="folder_id")
	private Folder folder;
	
	public Document() {
		super();
	}
	
	public Document(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFold(Folder folder) {
		this.folder = folder;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", content=" + content + ", folder=" + folder + "]";
	}

}
