package com.example.easynotes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.example.easynotes.entity.Task;
import com.example.easynotes.entity.User;
import com.example.easynotes.repository.TaskRepository;
 @Service  
public class TaskService { 
	  
	@Autowired      
     TaskRepository taskRepository;      
	UserService userService;
	
	public  void addTask(Task task,User user) {
		task.setUsers(user); 
		taskRepository.save(task);
		   
	}  
	public List<User> findUserTask(User user){  
		return taskRepository.findByUser(user); 
	} 
	 
	public List<Task> findAll(Task task,User user) {    
	  
		return taskRepository.findAll();
	}
	  

}
