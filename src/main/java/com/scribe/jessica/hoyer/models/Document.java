package com.scribe.jessica.hoyer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Document {
	@Id
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="creation_date", nullable=false)
	private String creation_date;
	
	@Column(name="modify_date", nullable=false)
	private String modify_date;
	
	@Column(name="file_path", nullable=false)
	private String file_path;
	
	@Column(name="content")
	private String content; // do I need a bigger datatype?
	
	public Document() {
		super();
	}
	
	public Document(int id, String title, String creation_date, String modify_date,
			String file_path, String content) {
		super();
		this.id = id;
		this.title = title;
		this.creation_date = creation_date;
		this.modify_date = modify_date;
		this.file_path = file_path;
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

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
