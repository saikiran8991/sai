package com.employees.timesheet.core.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employees.timesheet.core.entity.EmployeeTimesheet;

@Repository
public interface EmployeeTimesheetRepository extends JpaRepository<EmployeeTimesheet,Long> { 
	

   
       
  
}     
                 