package com.example.easynotes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;  
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
 
@Entity      

public class Task {
	@Id
	@GeneratedValue  
	private Long id;
	@NotEmpty
	private String Date;
	@NotEmpty 
	private String startTime;
	@NotEmpty 
	private String stoptTme;
	@NotEmpty
	private String description;  
	
	@ManyToOne
	@JoinColumn (name = "USER_EMAIL")
	private User user;
	  
	public Task() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStoptTme() {
		return stoptTme;
	}
	public void setStoptTme(String stoptTme) {
		this.stoptTme = stoptTme;
	}
	public String getDescription() {
		return description;   
	} 
	public void setDescription(String description) {
		this.description = description;
	} 
	public User getUsers() {
		return user;
	}
	public void setUsers(User users) {
		this.user = users;
	}
	public Task(String date, String startTime, String stoptTme, String description, User users) {
	 
		Date = date;
		this.startTime = startTime;
		this.stoptTme = stoptTme;
		this.description = description;
		this.user = users;
	}
	public Task(String date, String startTime, String stoptTme, String description) {
		
		Date = date;
		this.startTime = startTime;
		this.stoptTme = stoptTme;
		this.description = description;
	} 
	

}
