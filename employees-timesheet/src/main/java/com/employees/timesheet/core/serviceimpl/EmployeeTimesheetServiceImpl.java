package com.employees.timesheet.core.serviceimpl;

import java.util.Date;
import java.util.List;   
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.employees.timesheet.core.entity.EmployeeTimesheet;
import com.employees.timesheet.core.repository.EmployeeTimesheetRepository;
import com.employees.timesheet.core.service.EmployeeTimesheetService;
       
@Component 
public class EmployeeTimesheetServiceImpl implements EmployeeTimesheetService{  
    
	@Autowired (required = false)   
	private EmployeeTimesheetRepository employeeTimesheetRepository;  
	
	public Optional<EmployeeTimesheet> findById(Long id){   
		return employeeTimesheetRepository.findById(id);            
	}   
	public void addEmployee(EmployeeTimesheet employeeTimesheet){
		employeeTimesheetRepository.save(employeeTimesheet);
	}  
	public List<EmployeeTimesheet> delete(Long id){   
	employeeTimesheetRepository.deleteById(id);    
		return null;     
	}  
	 
	public EmployeeTimesheet updateEmployee(EmployeeTimesheet employeeTimesheet) { 
        employeeTimesheetRepository.save(employeeTimesheet); 
		return employeeTimesheet;      
	}
 
	public List<EmployeeTimesheet> findAllEmployees() {
		return employeeTimesheetRepository.findAll(); 
	}


  
}        
       