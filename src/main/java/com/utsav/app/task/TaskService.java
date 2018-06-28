package com.utsav.app.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsav.app.project.Project;
import com.utsav.app.project.ProjectRepository;


@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<String> getAllTasks(String projectId){
		List<Task> task = new ArrayList<>();
		List<String> ptask = new ArrayList<>();
		taskRepository.findByProjectId(projectId).forEach(task::add);
		Project m = projectRepository.findById(projectId).get();
		ptask.add("Project: "+m.getContent());
		int i = 1;
		for(Task r:task) {
			ptask.add("tid: "+r.getTid()+" Task"+i+": "+r.getContent());
			i++;
		}
		return ptask;
	}
	
	public String getTask(String id) {
		Task r = taskRepository.findById(id).get();
		return r.getContent();
	}

	public Task addTask(Task task) {
		if(task.getTid() != null) {
			taskRepository.save(task);
			return task;}
		else
			return null;
	}

	public void updateTask(Task task) {
		taskRepository.save(task);
		
	}

	public void deleteTask(String id) {
		taskRepository.deleteById(id);
	}
}
