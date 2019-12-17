package com.employees.timesheet.core.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.employees.timesheet.core.entity.EmployeeTimesheet;
import com.employees.timesheet.core.entity.SearchFilter;
import com.employees.timesheet.core.service.EmployeeTimesheetService;
import com.employees.timesheet.core.util.MyHttpResponse;
 
@RestController  
@RequestMapping("/api")    
public class EmployeeTimesheetController{    
    
	@Autowired     
	private EmployeeTimesheetService employeeTimesheetService;   
	Logger logger = LoggerFactory.getLogger(EmployeeTimesheetController.class);
	private Object EndDate;
	private Object StartDate;

	@RequestMapping(value = "/getEmployeesTmesheet/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable Long employeeId, HttpServletRequest request, HttpSession session) {
		logger.info("/api/id/" + employeeId); 
		logger.info("id :" + employeeId);
		MyHttpResponse response = new MyHttpResponse(); 
		try { 
			Optional<EmployeeTimesheet> employee = employeeTimesheetService.findById(employeeId); 
			response.setStatus("success"); 
			response.setData(employee); 
			response.setMessage("text message"); 
		} catch (Exception e) { 
			logger.error(e.getMessage()); 
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}  
		                                                                             
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/getAllEmployeesTimsheet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllEmployees(HttpServletRequest request, HttpSession session){
		MyHttpResponse response = new MyHttpResponse();    
		try {         
			List<EmployeeTimesheet> employee1 = employeeTimesheetService.findAllEmployees();      
			response.setStatus("success");     
			response.setData(employee1);    
			response.setMessage("text message"); 
		} catch (Exception e) {  
			logger.error(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  
		}  
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/deleteEmployeesTimesheet/{employeeId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable Long employeeId, HttpServletRequest request,
			HttpSession session) { 
		logger.info("/api/id/" + employeeId);
		logger.info("id :" + employeeId);
		MyHttpResponse response = new MyHttpResponse(); 
		try {
			List<EmployeeTimesheet> employee = employeeTimesheetService.delete(employeeId);
			response.setStatus("success");
			response.setData(employee);
			response.setMessage("deleted");
		} catch (Exception e) {
			logger.error(e.getMessage()); 
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
 
	@RequestMapping(value = "/addEmployeesTimesheet/{idNumber}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeTimesheet employeeTimesheet){
		  MyHttpResponse response = new MyHttpResponse();
		 
		try {                     
			employeeTimesheetService.addEmployee(employeeTimesheet);    
			response.setStatus("success");   
 			response.setData(employeeTimesheet); 
			response.setMessage("successfully saved");   
		} catch (Exception e) { 
			logger.error(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}    
		return new ResponseEntity<>(response, HttpStatus.OK);  
	}  
 
	@RequestMapping(value = "/updateEmployeesTimesheet", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTimesheet> updateEmployee(@Valid @RequestBody EmployeeTimesheet employeeTimesheet,
			HttpServletRequest request, HttpSession session) {
		MyHttpResponse response = new MyHttpResponse();
		try {  
      EmployeeTimesheet updateemployee = employeeTimesheetService.updateEmployee(employeeTimesheet);
			response.setStatus("success");
			response.setData(updateemployee);
			response.setMessage("text message");
		} catch (Exception e) { 
			logger.error(e.getMessage());
			return new ResponseEntity<EmployeeTimesheet>(employeeTimesheet, HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<EmployeeTimesheet>(employeeTimesheet, HttpStatus.OK);
	}
	  
	@PostMapping  
	public void filter (@Valid @RequestBody SearchFilter searchFilter) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(SearchFilter.class);
		criteria.add(Restrictions.between("Date", "StartDate", "EndDate"));
		List<SearchFilter> users = (List<SearchFilter>)criteria.list(); 
		session.getTransaction().commit(); 
        session.close();   
	  
	}
	
}  
