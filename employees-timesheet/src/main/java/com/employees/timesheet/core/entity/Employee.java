package com.employees.timesheet.core.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity (name = "EmployeeDetails") 

public class Employee {  

	@Id    
	@GeneratedValue 
	private Long       empid; 
	private String     firstName;  
	private String     lastName;  
	private String     userName; 
	private LocalDate  date; 
	private String     day;
	private String     phoneNumber;
	private String     alternatePhoneNumber;
	private String     bloodGroup;
	private Date       dateOfBirth; 
	private String     address;
	private String     Email;
	private String     departmentName; 
	private LocalTime  startTime;
	private LocalTime  endTime;
	private LocalTime  totalHours; 
	private String     totalWorkingDays;
	
	public Long getEmpid() {
		return empid; 
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public LocalTime getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(LocalTime totalHours) {
		this.totalHours = totalHours;
	}
	public String getTotalWorkingDays() {
		return totalWorkingDays;
	}
	public void setTotalWorkingDays(String totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}
	public Employee(Long empid, String firstName, String lastName, String userName, LocalDate date, String day,
			String phoneNumber, String alternatePhoneNumber, String bloodGroup, Date dateOfBirth, String address,
			String email, String departmentName, LocalTime startTime, LocalTime endTime, LocalTime totalHours,
			String totalWorkingDays) {
	
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.date = date;
		this.day = day;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.bloodGroup = bloodGroup;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		Email = email;
		this.departmentName = departmentName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalHours = totalHours;
		this.totalWorkingDays = totalWorkingDays;
	} 
	public Employee() {
		 
	}
	
}
