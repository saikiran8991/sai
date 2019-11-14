package com.employees.timesheet.core.repository;

 

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import com.employees.timesheet.core.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>,JpaSpecificationExecutor<Employee> { 
	@Query (" from  EmployeeDetails a where a.empid=:empid")
	public Iterable<Employee> findByempId(@PathVariable (value = "empid") Long empid);

	 
 
}                
  