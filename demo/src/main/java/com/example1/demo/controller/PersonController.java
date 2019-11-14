package com.example1.demo.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 
import com.example1.demo.entity.Person;
import com.example1.demo.service.PersonService;
 
@RestController    
public class PersonController {
	   
      @Autowired  
       PersonService personService;       
      @GetMapping("/views") 
      	public List<Person> findAll(){
  		return personService.findAll();  
  	}  
        
       @PostMapping       
       	public Person createPerson(@Valid @RequestBody Person person) {   
   		return personService.save(person);   
   	}  
       @GetMapping("/views/{id}") 
       public Optional<Person> findById(@PathVariable Long id) {
    	   Optional<Person> person = personService.findById(id);
		return person;
       }     
 
       @DeleteMapping("/views/{id}") 
       public Person deletePerson(@PathVariable Long id) {
    	   return personService.deleteById(id); 
    	    
       } 
       
       @PutMapping ("/views/{id}")   
       public ResponseEntity<Person> updatePerson(@PathVariable Long id,@RequestBody Person currentperson){
    	   Optional<Person> person = personService.findById(id);
    	   return new ResponseEntity<Person>(HttpStatus.OK);  
       } 
    
          
}