package SwaggerConfig.SwaggerConfig;
 
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
	
	List<Student> students = new ArrayList<>();
	{
		students.add(new Student("sai", "iv","india"));
		students.add(new Student("kiran", "v","usa"));
		students.add(new Student("sai", "vi","uk"));
		students.add(new Student("sai", "vii","new york"));
	} 
	
	@RequestMapping(value = "/getStudents")
	public List<Student> findAll(){
		return students;
	}  
	 
	 @RequestMapping(value = "/getStudent/{name}")
	    public Student getStudent(@PathVariable(value = "name") String name) {
	        return students
	        		.stream()
	        		.filter(X -> X .getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	    }
	 
	    @RequestMapping(value = "/getStudentByCountry/{country}")
	    public Student getStudentByCountry(@PathVariable(value = "country") String country) { 
	       
	       return students
	    		.stream().filter(x -> x.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList()).get(0);
	  
	    }
	 
	    @RequestMapping(value = "/getStudentByClass/{cls}")
	    public Student getStudentByClass(@PathVariable(value = "cls") String cls) {
	        return students.stream().filter(x -> x.getCls().equalsIgnoreCase(cls)).collect(Collectors.toList()).get(0);
	    }
	
	

}
