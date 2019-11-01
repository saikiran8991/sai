package com.database.database;

import java.util.Date; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.database.database.dao.PersonJdbcDao;
import com.database.database.entity.Person;

@SpringBootApplication
 
public class DatabaseApplication implements CommandLineRunner{
  private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired 
	PersonJdbcDao dao;
	
	public static void main(String[] args) { 
		SpringApplication.run(DatabaseApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
	  logger.info("All Users->{}",dao.findAll());
	  logger.info("user id 1 ->{}",dao.findById(1));
	  logger.info("deleting  5-> no of Rows deleted-{}", dao.deleteById(5));
	  logger.info("inserting  10 -> {} ",dao.insert(new Person(10,"kevin","america",new Date())));
	  logger.info("updating person 6 -> {} " , dao.update(new Person(6,"peter","kerala",new Date())));
	}  
     
 
} 
      