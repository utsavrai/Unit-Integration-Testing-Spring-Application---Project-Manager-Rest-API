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
import com.utsav.app.task.Task;
import com.utsav.app.task.TaskService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TaskServiceIntegrationTest {
	
	@Autowired
	private TaskService taskService;
	
	
	@Test
	public void testTaskHappyPath() {
		
		// Create a task
		Task aTask = new Task();
		aTask.setTid("Rtest1");
		aTask.setContent("testing");
		
		
		// Test adding the task
		Task newTask = taskService.addTask(aTask);
		
		// Verify the addition
		assertNotNull(newTask);
		assertNotNull(newTask.getTid());
		assertEquals("testing", newTask.getContent());
		
	}
}
