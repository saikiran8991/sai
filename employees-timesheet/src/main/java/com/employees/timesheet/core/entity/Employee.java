package com.employees.timesheet.core.entity;


import java.util.Date;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;  
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "employeedetails")  

public  class Employee  {      
	
	@Id       
	@GeneratedValue (strategy = GenerationType.IDENTITY)  	 
	private Long          id;   
	private String        firstName;           
	private String        lastName;        
	private String        employeeName;     
	private String        phoneNumber;   
	private String        alternatePhoneNumber;          
	private String        bloodGroup;       
	private Date          dateOfBirth;     
	private String        address;      
	private String     	  email; 
	private Date          joiningDate;
	public Long getId() {
		return id; 
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}
	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Employee(Long id, String firstName, String lastName, String employeeName, String phoneNumber,
			String alternatePhoneNumber, String bloodGroup, Date dateOfBirth, String address, String email,
			Date joiningDate) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.bloodGroup = bloodGroup;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.email = email;
		this.joiningDate = joiningDate;
	}
	public Employee() {
		
	}  
	  
}
