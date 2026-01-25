package com.Prateek.learn_JPA_and_Hibernate.course.SpringDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaCourseRepostory extends JpaRepository < SpringDataJpaCourse , Integer >{
	// Its Magic , No need of any EntityManager in SpringDataJpa 
	// No need to define any methods all done internally,
	
	// Coustom methods following the convenctions of Spring-Data-Jpa
	
	List<SpringDataJpaCourse> findByAuthor(String author);
	
	List<SpringDataJpaCourse> findByName(String name);

}