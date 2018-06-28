package com.utsav.integration.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.utsav.app.project.Project;
import com.utsav.app.project.ProjectRepository;
import com.utsav.app.task.Task;
import com.utsav.app.task.TaskRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TaskRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	private TaskRepository taskRepository;
	
	@Test
    public void testFindById() {
		
		// setup data scenario
		Task aTask = new Task();
		aTask.setTid("Rtest2");
		aTask.setContent("testing");
		Project m = new Project();
		m.setId("test2");
		aTask.setProject(m);
		entityManager.persist(aTask);
        // Find an inserted record using repository class
        Task foundTask = taskRepository.findById("Rtest2").get();
        
        
        // Assertion
        assertThat(foundTask.getTid(), is(equalTo("Rtest2")));
    }
	
}
