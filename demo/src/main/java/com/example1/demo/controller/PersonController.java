package com.example1.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    @DeleteMapping
    public Person deleteById(@RequestParam Long id) {
    	return personService.deleteById(id);
    }
         
}  
