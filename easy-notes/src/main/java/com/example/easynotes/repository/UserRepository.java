package com.example.easynotes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
  
import com.example.easynotes.entity.User; 

public interface UserRepository extends JpaRepository <User,String> {
 
	List<User> findByName(String name); 
 
} 
    