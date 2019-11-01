package com.example.easynotes.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.easynotes.entity.Role;
import com.example.easynotes.entity.User; 
import com.example.easynotes.repository.UserRepository;
  
@Service
public class UserService { 
	
	@Autowired
	UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role();
		List<Role> roles = new ArrayList<>(); 
		roles.add(userRole); 
		user.setRoles(roles);
		userRepository.save(user); 
		 
	}
	public void createAdmin(User user) {  
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role();
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);   
		 
	}    
	 
	public User findOne(String email) {
		return userRepository.getOne(email);
	}
	

}
