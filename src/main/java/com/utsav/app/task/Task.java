package com.utsav.app.task;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.utsav.app.project.Project;

@Entity
public class Task {
	@Id
	private String tid;
	private String content;
	
	@ManyToOne
	private Project project;
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Task() {
		
	}
	
	public Task(String tid, String content) {
		super();
		this.tid = tid;
		this.content = content;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}	
}
