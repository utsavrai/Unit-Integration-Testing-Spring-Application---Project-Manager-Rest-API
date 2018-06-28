package com.utsav.app.project;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsav.app.task.Task;
import com.utsav.app.task.TaskRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<String> getAllProjects(){
		List<Project> projects = new ArrayList<>();
		List<String> projs = new ArrayList<>();
		projectRepository.findAll().forEach(projects::add);
		int i = 1;
		for(Project m :projects) {
			projs.add("ID: "+m.getId()+", Project"+i+" :"+m.getContent());
			i++;
		}
		return projs;
	}
	
	public String getProject(String id) {
		return projectRepository.findById(id).get().getContent();
	}

	public Project addProject(Project project) {
		//topics.add(topic);
		if(project.getId() != null) {
			projectRepository.save(project);
			return project;}
		else
			return null;
	}

	public void updateProject(String id, Project project) {
		projectRepository.save(project);
		
	}

	public void deleteProject(String id) {
		//get all tasks for project id = id
		List<Task> replies  = new ArrayList<>();
		taskRepository.findByProjectId(id).forEach(replies::add);
		//delete all the tasks for that project
		for(Task r:replies) {
			taskRepository.deleteById(r.getTid());
		}
		//then delete the project
		projectRepository.deleteById(id);
	}
}
