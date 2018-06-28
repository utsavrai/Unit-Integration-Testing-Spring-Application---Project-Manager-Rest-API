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

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ProjectRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;

	@Autowired
	private ProjectRepository projectRepository;
	
	@Test
    public void testFindById() {
		
		// setup data scenario
		Project aProject = new Project();
		aProject.setId("test2");
		entityManager.persist(aProject);
        // Find an inserted record using repository class
        Project foundProject = projectRepository.findById("test2").get();
        
        
        // Assertion
        assertThat(foundProject.getId(), is(equalTo("test2")));
    }
	
}
