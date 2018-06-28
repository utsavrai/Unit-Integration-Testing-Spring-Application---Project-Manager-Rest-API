package com.utsav.app.task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,String>{

	public List<Task> findByProjectId(String projectId);

}
