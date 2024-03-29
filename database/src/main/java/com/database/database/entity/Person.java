package com.database.database.entity;

import java.util.Date;

public class Person { 
	
	
	private int id; 
	private String name;
	private String location;
    private Date birthDate; 
	
	public Person() {
		
	}

	public Person(int id, String name, String location,  Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthdate() {
		return birthDate;
	}  

	public void setBirthdate(Date birthdate) {
		this.birthDate = birthdate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthdate=" + birthDate + "]";
	}

	
	}

