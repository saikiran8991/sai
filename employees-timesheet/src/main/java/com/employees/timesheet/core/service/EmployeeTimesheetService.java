package com.employees.timesheet.core.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.query.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.employees.timesheet.core.entity.EmployeeTimesheet;

@Component  
public interface EmployeeTimesheetService {  
	 
	public Optional<EmployeeTimesheet> findById(Long id);
	public void addEmployee(EmployeeTimesheet employeeTimesheet);
	public List<EmployeeTimesheet> delete(Long id);
	public List<EmployeeTimesheet> findAllEmployees(); 
	public EmployeeTimesheet updateEmployee(EmployeeTimesheet employeeTimesheet);
	
 

 
		     
}      
    