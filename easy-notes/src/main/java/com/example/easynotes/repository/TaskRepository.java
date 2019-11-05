package com.example.easynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.easynotes.entity.Task;
import com.example.easynotes.entity.User;
@Repository 
public interface TaskRepository extends JpaRepository <Task,Long>{ 
 
	List<User> findByUser(User user);
       
   
}   
        