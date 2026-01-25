package com.Prateek.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// i am making a REST-API 
// when a call goes onto this url :- http://localhost:8080/course
// some course data is returned :  list of object(s)
/**
 [
 	{
 		"id":1,
 		"name":"Learn Aws",
 		"author:"in28Minutes"
 	}
 ]
 	
 */


// http://localhost::8080 	: is where your project is running locally 
// 		/courses  : on this route you have some data that you want to fetch or somethingg...

@RestController
public class CourseController {
	
	@RequestMapping("/courses")   // now whenever "/courses" url hits this method runs.
	public List<Course> retrieveAllCourses(){
		
		return Arrays.asList(
					new Course(1,"Learn AWS","in28Minutes"),
					new Course(2,"Learn Java Backend","in28Minutes")
				);
				
	}
	
}
