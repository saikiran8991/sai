package com.employees.timesheet.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping; 
  
@RestController  
@RequestMapping ("/employees") 
public class EmployeeController {
	
	@Autowired   
	private  EmployeeService employeeService;  
	 
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping (value = "/api/id/{idNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable Long idNumber, HttpServletRequest request, HttpSession session){
		 
		logger.info("/api/id/" +idNumber);
		logger.info("id :" +idNumber);
		MyHttpResponse response = new MyHttpResponse();
		
		try { 
			Employee employee = employeeService.findById(idNumber);
			response.setStatus("success");
			response.setData(employee);
			response.setMessage("text message");  
			 
			  
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping (value = "/api/id/{idNumber}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable Long idNumber, HttpServletRequest request, HttpSession session){
		
		logger.info("/api/id/" +idNumber);
		logger.info("id :" +idNumber);
		MyHttpResponse response = new MyHttpResponse();
		
		try { 
			
			List<Employee> employee = employeeService.delete(idNumber);  
			response.setStatus("success");  
			response.setData(employee);
			response.setMessage("deleted");     
  
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping (value = "/api/id", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  addEmployee(@Valid @RequestBody Employee employee, HttpServletRequest request, HttpSession session){

		MyHttpResponse response = new MyHttpResponse();
		 
		try {  
		      employeeService.addEmployee(employee);     
			response.setStatus("success"); 
			response.setData(employee);     
			response.setMessage("successfully saved");       
	  
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}

	@RequestMapping (value = "/api/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllEmployees( HttpServletRequest request, HttpSession session){
 
		MyHttpResponse response = new MyHttpResponse();
		
		try {  
			List<Employee> employee = employeeService.findAllEmployees(); 
		 	employeeService.findAllEmployees();  
			response.setStatus("success");  
			response.setData(employee);   
			response.setMessage("text message"); 
			 
			  
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping (value = "/api/id/{idNumber}",method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateEmployee (@PathVariable Long idNumber,@Valid @RequestBody Employee employee, HttpServletRequest request,HttpSession session){
		
				logger.info("/api/id/" +idNumber);
				logger.info("id :" +idNumber);
			MyHttpResponse response = new MyHttpResponse(); 
			 
		try {
	 	Employee newemployee = employeeService.updateEmployee(idNumber, employee);
	     employeeService.save(employee); 
			response.setStatus("success"); 
			response.setData(newemployee); 
			response.setMessage("text message");
			
			  
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
