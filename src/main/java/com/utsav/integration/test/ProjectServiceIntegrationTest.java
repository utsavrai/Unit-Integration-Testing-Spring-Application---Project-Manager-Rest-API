package com.utsav.integration.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.utsav.app.project.Project;
import com.utsav.app.project.ProjectService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ProjectServiceIntegrationTest {
	
	@Autowired
	private ProjectService projectService;
	
	
	@Test
	public void testAddContactHappyPath() {
		
		// Create a project
		Project aProject = new Project();
		aProject.setId("test1");
		aProject.setContent("testing");
		
		
		// Test adding the project
		Project newProject = projectService.addProject(aProject);
		
		// Verify the addition
		assertNotNull(newProject);
		assertNotNull(newProject.getId());
		assertEquals("testing", newProject.getContent());
		
	}
}
