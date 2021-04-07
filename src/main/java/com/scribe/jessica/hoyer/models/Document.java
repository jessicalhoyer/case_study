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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((content == null) ? 0 : content.hashCode());
//		result = prime * result + ((folder == null) ? 0 : folder.hashCode());
//		result = prime * result + id;
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Document other = (Document) obj;
//		if (content == null) {
//			if (other.content != null)
//				return false;
//		} else if (!content.equals(other.content))
//			return false;
//		if (folder == null) {
//			if (other.folder != null)
//				return false;
//		} else if (!folder.equals(other.folder))
//			return false;
//		if (id != other.id)
//			return false;
//		if (title == null) {
//			if (other.title != null)
//				return false;
//		} else if (!title.equals(other.title))
//			return false;
//		return true;
//	}
	
	

}
