package com.example1.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id; 
 
@Entity    
public class Person {  
	
	@Id    
	private Long id; 
	private String fullname; 
	private String lastname;  
    private String starttime;
    private String stoptime;   

     
	public Long getId() { 
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getLastname() {
		return lastname;
	} 
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStoptime() {
		return stoptime;
	}  
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}
	
	public Person(Long id, String fullname, String lastname, String starttime, String stoptime, String description) {
	
		this.id = id; 
		this.fullname = fullname;
		this.lastname = lastname;
		this.starttime = starttime;
		this.stoptime = stoptime;
	}
	public Person() {
 
	}
}
