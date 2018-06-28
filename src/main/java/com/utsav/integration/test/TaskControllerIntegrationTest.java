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
import com.utsav.app.project.ProjectRepository;
import com.utsav.app.task.Task;
import com.utsav.app.task.TaskController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TaskControllerIntegrationTest {

	@Autowired
	TaskController taskController;
	@Autowired 
	ProjectRepository projectRepository;
	@Test
	public void testAddTaskHappyPath() {
		
		Task aTask = new Task();
		aTask.setTid("test1");
		aTask.setContent("testing");
		Project m = projectRepository.findById("test1").get();
		aTask.setProject(m);
		
		// POST our task form bean to the controller; check the outcome
		String outcome = taskController.processSubmit(aTask);
		
		// Assert THAT the outcome is as expected
		assertThat(outcome,is(equalTo("success")));
	}
	
	@Test
	public void testAddTaskContentMissing() {
		Task aTask = new Task();
		String outcome = taskController.processSubmit(aTask);
				
		// Assert THAT the outcome is as expected
		assertThat(outcome,is(equalTo("failure")));
		
	}
}
