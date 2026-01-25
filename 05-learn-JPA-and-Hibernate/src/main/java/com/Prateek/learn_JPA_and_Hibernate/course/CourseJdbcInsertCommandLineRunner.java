package com.Prateek.learn_JPA_and_Hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// theory is in notes for this.
// this class needs to be a bean. in which there is some dependency that is Autowired.
@Component
public class CourseJdbcInsertCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJdbcRepositoryInsert repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Course cr = new Course(1,"Learn SpringBoot","in28Minutes");
		Course cr2 = new Course(3,"Learn DSA","TUF");
		Course cr3 = new Course(4,"Learn FrontEndDev","ChaiAurCode");

		repo.insert(cr);
		repo.insert(cr2);
		repo.insert(cr3);
		
		repo.delete(new Course(3)); // course with ID=3 must get deleted as well.
		
		Course cr4 = repo.findCourseById(1);
		
		System.out.println("Using Spring-JDBC : "+cr4);
		
	}
	
}
