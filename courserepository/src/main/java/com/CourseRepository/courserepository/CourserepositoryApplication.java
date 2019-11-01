package com.CourseRepository.courserepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.CourseRepository.courserepository.repository.CourseRepository;
  
@SpringBootApplication  
@RestController

public class CourserepositoryApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CourserepositoryApplication.class, args);
	}

	@Override 
	public void run(String... args) throws Exception {
		
		logger.info("course  10145L -> {}",  repository.findById(10145L));

	}
 
}
