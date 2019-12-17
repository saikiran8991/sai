package com.employees.timesheet.core.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.employees.timesheet.core.entity.Employee;
import com.employees.timesheet.core.service.EmployeeService;
import com.employees.timesheet.core.util.MyHttpResponse;
import org.springframework.web.bind.annotation.RequestBody; 

@RestController 
@RequestMapping("/api")
public class EmployeeController { 
	@Autowired 
	private EmployeeService employeeService; 
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@RequestMapping(value = "/getEmployees/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable Long employeeId, HttpServletRequest request, HttpSession session) {
		logger.info("/api/id/" + employeeId);
		logger.info("id :" + employeeId); 
		MyHttpResponse response = new MyHttpResponse();
		try {   
			Optional<Employee> employee = employeeService.findById(employeeId);     
			response.setStatus("success");      
			response.setData(employee);     
			response.setMessage("text message");
		} catch (Exception e) { 
			logger.error(e.getMessage());   
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST); 
		}  
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<java.lang.Object> getAllEmployees( HttpServletRequest request, HttpSession session){
		MyHttpResponse response = new MyHttpResponse();    		
		try {         
			List<Employee> employee1 = employeeService.findAllEmployees();      
			response.setStatus("success");     
			response.setData(employee1);   
			response.setMessage("text message");
		} catch (Exception e) {  
			logger.error(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} 
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/deleteEmployees/{employeeId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable Long employeeId, HttpServletRequest request, HttpSession session) {
		logger.info("/api/id/" + employeeId);
		logger.info("id :" + employeeId);
		MyHttpResponse response = new MyHttpResponse();
		try { 
			List<Employee> employee = employeeService.delete(employeeId);
			response.setStatus("success");
			response.setData(employee);
			response.setMessage("deleted"); 
		} catch (Exception e) { 
			logger.error(e.getMessage());    
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@RequestMapping(value = "/addEmployees", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee ) {
		MyHttpResponse response = new MyHttpResponse();
		try {                     
			employeeService.addEmployee(employee);    
			response.setStatus("success");  
			response.setData(employee);
			response.setMessage("successfully saved"); 
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}   
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}

	@RequestMapping(value = "/updateEmployees", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee employee, HttpServletRequest request,
			HttpSession session) {
		MyHttpResponse response = new MyHttpResponse(); 
		try {
			Employee updateemployee = employeeService.updateEmployee(employee);
			response.setStatus("success");
			response.setData(updateemployee);
			response.setMessage("text message");     	
			
		} catch (Exception e) {	
			logger.error(e.getMessage()); 
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); 
		} 
			return new ResponseEntity<>(response, HttpStatus.OK);
	}   
	
	
}     
