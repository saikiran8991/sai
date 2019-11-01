package com.example.easynotes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.easynotes.entity.Task;
import com.example.easynotes.entity.User;
import com.example.easynotes.repository.TaskRepository; 
import com.example.easynotes.services.TaskService;
import com.example.easynotes.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration

public class EasyNotesApplicationTests { 

	@Autowired
	UserService userService;   
	@Autowired
	TaskService taskService; 
	
	 @Before(value = "")    
	public void initDb() {    
		{
			User newUser = new User("testUser@gmail.com","saikiran","12345678");
			userService.createUser(newUser);
		}
		 
		{
			User newUser = new User("testAdmin@gmail.com","saikiran","12345678");
			userService.createUser(newUser);
		}
		Task userTask = new Task ("4-5-2019","1:00","4:00","your have to stay here");
		User user = userService.findOne("testUser@gmail.com");
		taskService.addTask(userTask, user);
		
	} 
	   
	@Test      
    public void testUser() {  
  	  User user = userService.findOne("testUser@mail.com");
        assertNotNull(user);
  	  User admin = userService.findOne("testAdmin@mail.com");
  	  assertEquals(admin.getEmail(),"testAdmin@mail.com");
    }
    
    @Test 
    public void testTask() {
  	  User user = userService.findOne("testUser@mail.com");
  	  List<User> task = taskService.findUserTask(user);
  	  assertNotNull(task);  
    } 
	

}
