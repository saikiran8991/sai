package com.employees.timesheet.core.entity;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table (name = "employeesTimesheet")
public class EmployeeTimesheet{ 
	@Id      
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long 		      id;    
	private Long 		   ticketNo;  
	private Long 		   sprintNo;   
	private String 		   projectName; 
	private Date           totalHours;    
	private String 		   summary; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date           startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date           endDate; 
	private String         leaves;   
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "employee_id",nullable = false)    
	private Employee employee;

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(Long ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Long getSprintNo() {
		return sprintNo;
	}

	public void setSprintNo(Long sprintNo) {
		this.sprintNo = sprintNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Date totalHours) { 
		this.totalHours = totalHours;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLeaves() {
		return leaves;
	}

	public void setLeaves(String leaves) {
		this.leaves = leaves;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeTimesheet(Long id, Long ticketNo, Long sprintNo, String projectName, Date totalHours, String summary,
			Date startDate, Date endDate, String leaves, Employee employee) {
		this.id = id;
		this.ticketNo = ticketNo;
		this.sprintNo = sprintNo;
		this.projectName = projectName;
		this.totalHours = totalHours;
		this.summary = summary;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaves = leaves;
		this.employee = employee;
	}

	public EmployeeTimesheet() {
	
	}
}
