package com.employees.timesheet.core.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employees.timesheet.core.entity.Employee;
import com.employees.timesheet.core.repository.EmployeeRepository;
import com.employees.timesheet.core.service.EmployeeService;

@Component 
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired   
	private EmployeeRepository employeeRepository; 
	 
	public Employee findById(Long id) {
		Iterable<Employee> datas = employeeRepository.findByempId(id);
		Employee dto = null; 
		return datas.iterator().next();
		     
	}
	
	  
	 public List<Employee> delete(Long id) {  
		 employeeRepository.deleteById(id);
		 return null;
		 
	 }
	  
	  public void addEmployee(Employee employee) {
			  employeeRepository.save(employee);
			 
		}    
 
 
	  public List<Employee> findAllEmployees(){
		  List<Employee> employee = new ArrayList<>();
		  employeeRepository.findAll().forEach(employee::add);
		  return employee; 
    	
	  }   
	
    public Employee updateEmployee(Long id,Employee employee) {
	 Employee employee1 = employeeRepository.save(employee);
	 return employee1;
	 
 }


	@Override
	public void save(Employee newemployee) {
		// TODO Auto-generated method stub
		
	}

     
	  

}
