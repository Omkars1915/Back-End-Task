package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.TaskDao;
import com.project.entity.Task;
import com.project.entity.User;
import com.project.model.TaskDTO;

@Service
public class TaskServiceImple implements TaskService {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public String createTask(TaskDTO taskdto) {
		Task task=new Task();
		
		task.setTask_id(taskdto.getTask_id());
		task.setTitle(taskdto.getTitle());
		task.setDescription(taskdto.getDescription());
		task.setStatus(taskdto.getStatus());
		task.setPriority(taskdto.getPriority());
		task.setDue_date(taskdto.getDue_date());
		task.setCreated_at(taskdto.getCreated_at());
		task.setUpdated_at(taskdto.getUpdated_at());
		task.setUser(userservice.getUserById(taskdto.getU_id()));
		return taskDao.createTask(task);
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> getalltasks=taskDao.getAllTasks();
		return getalltasks;
	}

	@Override
	public Task getTaskById(long id) {
		Task gettaskbyid=taskDao.getTaskById(id);
		return gettaskbyid;
	}

	
	@Override
	public String updateTask(long id,Task task) {
		
		Task existingtask=taskDao.getTaskById(id);
		
		User existinguser=existingtask.getUser();
		
		existingtask.setTitle(task.getTitle());
		existingtask.setDescription(task.getDescription());
		existingtask.setStatus(task.getStatus());
		existingtask.setPriority(task.getPriority());
		existingtask.setDue_date(task.getDue_date());
		existingtask.setCreated_at(task.getCreated_at());
		existingtask.setUpdated_at(task.getUpdated_at());
		existingtask.setUser(existinguser);
	
		return taskDao.updateTask(id, existingtask);
	}

	@Override
	public String deleteTaskById(long id) {
		String deletetaskbyid=taskDao.deleteTaskById(id);
		return deletetaskbyid;
	}

	@Override
	public Task getTaskByName(String title) {
		Task gettaskbyname=taskDao.getTaskByName(title);
		return gettaskbyname;
	}

	@Override
	public List<Task> filterTask(String status, String priority, String dueDate) {
		List<Task> filtertask=taskDao.filterTask(status, priority, dueDate);
		return filtertask;
	}


}
