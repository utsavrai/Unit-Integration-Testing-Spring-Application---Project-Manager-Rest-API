package com.utsav.app.task;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utsav.app.project.Project;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/projects/{id}/tasks")
	public List<String> getAllTasks(@PathVariable String id){
		return taskService.getAllTasks(id);
	}
	
	@RequestMapping("/projects/{projectId}/tasks/{id}")
	public String getTask(@PathVariable String id) {
		return taskService.getTask(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/projects/{projectId}/tasks")
	public void addTask(@RequestBody Task task,@PathVariable String projectId) {
		task.setProject(new Project(projectId,""));
		taskService.addTask(task);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/projects/{projectId}/tasks/{id}")
	public void updateTask(@RequestBody Task task,@PathVariable String projectId, @PathVariable String id) {
		task.setProject(new Project(projectId,""));
		taskService.updateTask(task);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/projects/{projectId}/tasks/{id}")
	public void deleteTask(@PathVariable String id) {
		taskService.deleteTask(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/projects/{projectId}/tasks/{id}")
	public String processSubmit(@RequestBody Task aTask) {
		if(aTask.getProject() !=null) {
			Task newTask = taskService.addTask(aTask);
			if (newTask != null) {
				return "success";
			}
			System.out.println("failure");
			return "failure";
		}else{
			return "failure";
		}
	}
}
