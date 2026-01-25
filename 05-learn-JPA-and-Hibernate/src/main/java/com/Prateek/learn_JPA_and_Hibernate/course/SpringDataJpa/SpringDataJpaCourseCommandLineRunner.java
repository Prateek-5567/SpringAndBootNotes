package com.Prateek.learn_JPA_and_Hibernate.course.SpringDataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJpaCourseCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private SpringDataJpaCourseRepostory Repo_object;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Repo_object.save(new SpringDataJpaCourse(10,"Learn Dsa","Babbar"));
		Repo_object.save(new SpringDataJpaCourse(11,"Learn SQl","Lakshay"));
		Repo_object.save(new SpringDataJpaCourse(12,"Learn OS","Lakshay"));
		Repo_object.save(new SpringDataJpaCourse(13,"Learn SpringBoot","Reddy"));
		
		Repo_object.deleteById(11); // if methods expects long then you pass 11l
		
		System.out.println("Using Jpa : "+Repo_object.findById(10));
		System.out.println("Using Jpa : "+Repo_object.findById(12));
		
		System.out.println(Repo_object.findAll()); // print all the records from Course : Select * from Course.
		System.out.println(Repo_object.count()); // Select Count(*) from Course;

		// Coustom Methods
		System.out.println(Repo_object.findByAuthor("Lakshay"));
		System.out.println(Repo_object.findByAuthor("in28Minutes"));
		System.out.println(Repo_object.findByAuthor(""));
		System.out.println(Repo_object.findByName("Learn Dsa")); // case Sensitive

	
	
	}
}
