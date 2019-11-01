package com.example.easynotes.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.easynotes.entity.Task;
import com.example.easynotes.entity.User;

public interface TaskRepository extends JpaRepository <Task ,Long>{

	List<User> findByUser(User user);
 
  

	
 
} 
