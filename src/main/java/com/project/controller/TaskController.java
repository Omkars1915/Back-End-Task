package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Task;
import com.project.model.TaskDTO;
import com.project.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/createtask")
	public String createTask(@RequestBody TaskDTO task) {
		String createtask=taskService.createTask(task);
		return createtask;
	}
	
	@GetMapping("/get-all-tasks")
	public List<Task> getAllTasks(){
		List<Task> getalltasks=taskService.getAllTasks();
		return getalltasks;	
	}
	
	@GetMapping("/get-task-by-id/{id}")
	public Task getTaskById(@PathVariable long id) {
		Task gettaskbyid=taskService.getTaskById(id);
		return gettaskbyid;
	}
	
	@PutMapping("/update-task/{id}")
	public String updateTask(@PathVariable long id,@RequestBody Task task) {
		String updatetask=taskService.updateTask(id, task);
		return updatetask;
	}
	
	@DeleteMapping("/delete-task-by-id/{id}")
	public String deleteTaskById(@PathVariable long id) {
		String deletetaskbyid=taskService.deleteTaskById(id);
		return deletetaskbyid;
	}
	
	@GetMapping("/get-task-by-title/{title}")
	public Task getTaskByName(@PathVariable String title) {
		Task gettaskbyname=taskService.getTaskByName(title);
		return gettaskbyname;
	}
	
	@GetMapping("/tasks")
	public List<Task> filterTask(@RequestParam String status,
			@RequestParam String priority,
			@RequestParam String dueDate){
		List<Task> filtertask=taskService.filterTask(status, priority, dueDate);
		return filtertask;
	}
	
}
