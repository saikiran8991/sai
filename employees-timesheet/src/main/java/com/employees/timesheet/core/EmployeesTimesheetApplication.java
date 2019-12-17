package com.employees.timesheet.core;
 

/**
 * This class will be used as a EmployeesTimesheet.
 * @author employees.
 */
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication   
@EnableJpaAuditing   
@EnableSwagger2 
@EnableAutoConfiguration  
@Configuration 
@ComponentScan(basePackages = "com.employees.timesheet.core*")     
public class EmployeesTimesheetApplication {  
  
	public static void main(String[] args) { 
		SpringApplication.run(EmployeesTimesheetApplication.class, args);
	} 
      
	  @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)  
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .build();
	  }
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder() 
				.title("Employees Timesheet API's")
				.description("this page list all the rest apis for Employees Timesheet app")
				.version("1.0-SNAPSHOT")
		 		.build();		
				
	}
	 
}  
    