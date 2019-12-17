package com.employees.timesheet.core.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Component;
import com.employees.timesheet.core.entity.Employee;

@Component
public interface EmployeeService  {  
 
	public Optional<Employee> findById(Long id); 
	public void addEmployee(Employee employee); 
	public List<Employee> delete(Long id);  
	public List<Employee> findAllEmployees();  
	public Employee updateEmployee(Employee employee);
	 
	 
}  
   
    
  