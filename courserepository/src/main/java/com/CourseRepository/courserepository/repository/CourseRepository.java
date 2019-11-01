package com.CourseRepository.courserepository.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourseRepository.courserepository.entity.Course;
@Repository
public class CourseRepository {  
	
	@Autowired
	EntityManager em;
	 
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	
	

}
