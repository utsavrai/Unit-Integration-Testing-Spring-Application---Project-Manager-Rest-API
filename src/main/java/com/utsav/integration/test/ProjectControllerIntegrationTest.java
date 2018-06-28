package com.utsav.integration.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.utsav.app.project.Project;
import com.utsav.app.project.ProjectController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectControllerIntegrationTest {

	@Autowired
	ProjectController projectController;
	
	@Test
	public void testAddProjectHappyPath() {
		
		Project aProject = new Project();
		aProject.setId("test1");
		aProject.setContent("testing");
		
		String outcome = projectController.processAddProjectSubmit(aProject);
		
		// Assert THAT the outcome is as expected
		assertThat(outcome,is(equalTo("success")));
	}
	
	@Test
	public void testAddProjectContentMissing() {
		Project aProject = new Project();
		// POST our CustomerContact form bean to the controller; check the outcome
		String outcome = projectController.processAddProjectSubmit(aProject);
				
		// Assert THAT the outcome is as expected
		assertThat(outcome,is(equalTo("failure")));
		
	}
}
