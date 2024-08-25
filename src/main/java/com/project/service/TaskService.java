package com.project.service;

import java.util.List;

import com.project.entity.Task;
import com.project.model.TaskDTO;

public interface TaskService {
	
	public String createTask(TaskDTO taskdto);

	public List<Task> getAllTasks();

	public String updateTask(long id,Task task);

	public Task getTaskById(long id);

	public String deleteTaskById(long id);

	public Task getTaskByName(String title);

	public List<Task> filterTask(String status, String priority, String dueDate);

}
