	package com.utsav.app.project;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	private String id;
	private String content;
	public Project() {	
	}
	public Project(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
