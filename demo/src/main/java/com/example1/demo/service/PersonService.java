package com.example1.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example1.demo.entity.Person;
import com.example1.demo.repository.PersonRepository;

@Service 
public class PersonService {  

	@Autowired
	PersonRepository personRepository;
	  
	public List<Person> findAll(){  
		return personRepository.findAll();
	}
	
	public Person findById( Long id) {
		return personRepository.getOne(id);
	}
	     
	public Person save(Person person) {
		return personRepository.save(person);  
	} 
	
	public Person deleteById( Long id) {
		personRepository.deleteById(id);
		return null; 
	} 

  
}
