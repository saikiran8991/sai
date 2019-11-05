package com.example1.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity  
public class Person {  
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; 
	private String fullname; 
	private String lastname;
	private String phonenumber;  
	 
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
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
 
	public Person(Long id, String fullname, String lastname, String phonenumber) {
		this.id = id;
		this.fullname = fullname;
		this.lastname = lastname;
		this.phonenumber = phonenumber; 
		
	}
	public Person() {
	
	}
	
	 
	
	

}
