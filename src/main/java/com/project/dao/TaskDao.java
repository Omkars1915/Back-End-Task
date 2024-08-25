package com.project.dao;

import java.util.List;

import com.project.entity.Task;

public interface TaskDao {

	String createTask(Task task);

	List<Task> getAllTasks();

	String updateTask(long id,Task task);

	Task getTaskById(long id);

	String deleteTaskById(long id);

	Task getTaskByName(String title);

	List<Task> filterTask(String status, String priority, String dueDate);

}
