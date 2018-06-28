package com.utsav.app.project;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/projects")
	public List<String> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@RequestMapping("/projects/{id}")
	public String getProject(@PathVariable String id) {
		return projectService.getProject(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/projects")
	public void addProject(@RequestBody Project project) {
		projectService.addProject(project);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/projects/{id}")
	public void updateProject(@RequestBody Project project, @PathVariable String id) {
		projectService.updateProject(id,project);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/projects/{id}")
	public void deleteProject(@PathVariable String id) {
		projectService.deleteProject(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processAddProjectSubmit(@RequestBody Project aProject) {
		if(aProject !=null) {
			Project newProject = projectService.addProject(aProject);
			if (newProject != null) {
				return "success";
			}
			System.out.println("failure");
			return "failure";
		}else {
			return "failure";
		}
	}
	
}
