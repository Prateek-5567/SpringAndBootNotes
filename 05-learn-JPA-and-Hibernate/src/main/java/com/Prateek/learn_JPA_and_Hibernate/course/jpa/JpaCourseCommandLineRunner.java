//package com.Prateek.learn_JPA_and_Hibernate.course.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JpaCourseCommandLineRunner implements CommandLineRunner{
//	
//	@Autowired
//	private JpaCourseRepository JCR;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		JCR.insert(new JpaCourse(10,"Learn Dsa","Babbar"));
//		JCR.insert(new JpaCourse(11,"Learn SQl","Lakshay"));
//		JCR.insert(new JpaCourse(12,"Learn OS","Lakshay"));
//		
//		JCR.deleteByID(11);
//		
//		System.out.println("Using Jpa : "+JCR.findById(10));
//		System.out.println("Using Jpa : "+JCR.findById(12));
//
//	}
//
//}
