package com.utsav.app.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.utsav.integration.test.ProjectControllerIntegrationTest;
import com.utsav.integration.test.ProjectRepositoryIntegrationTest;
import com.utsav.integration.test.ProjectServiceIntegrationTest;
import com.utsav.integration.test.TaskControllerIntegrationTest;
import com.utsav.integration.test.TaskRepositoryIntegrationTest;
import com.utsav.integration.test.TaskServiceIntegrationTest;



@RunWith(Suite.class)
@Suite.SuiteClasses ({ ProjectServiceIntegrationTest.class, 
	ProjectControllerIntegrationTest.class, ProjectRepositoryIntegrationTest.class, TaskServiceIntegrationTest.class, 
	TaskControllerIntegrationTest.class, TaskRepositoryIntegrationTest.class })
public class FeatureTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}
