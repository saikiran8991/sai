package com.employees.timesheet.core.serviceimpl;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.employees.timesheet.core.entity.Employee;
import com.employees.timesheet.core.repository.EmployeeRepository;
import com.employees.timesheet.core.service.EmployeeService;

  
@Component   
public class EmployeeServiceImpl implements EmployeeService { 
	  
	@Autowired  (required = false)   
	private EmployeeRepository employeeRepository;     
	   
	public Optional<Employee> findById(Long id) {
	return employeeRepository.findById(id);    
     
	}           
    public List<Employee> delete(Long id) {      
		 employeeRepository.deleteById(id);
		       return null; 	   
	 }    
       
	
	public List<Employee> findAllEmployees(){  
		  return employeeRepository.findAll();  
		   
	  } 


	public void addEmployee(Employee employee) { 
		employeeRepository.save(employee);
		
	}
	
	public Employee updateEmployee( Employee employee) { 
		return employeeRepository.save(employee);

		  
	}    
   
} 
   