package com.employees.timesheet.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing  
@EnableSwagger2
@Configuration 
@ComponentScan(basePackages = "com.employees.timesheet.core*")
public class EmployeesTimesheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesTimesheetApplication.class, args);
	}
 
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework")))
				.build(); 
	}
		 
	 
} 
 