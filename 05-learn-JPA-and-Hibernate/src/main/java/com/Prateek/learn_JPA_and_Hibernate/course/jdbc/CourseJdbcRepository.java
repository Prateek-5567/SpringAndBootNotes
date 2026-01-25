package com.Prateek.learn_JPA_and_Hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate courseJdbcTemplate; // you need an object of JdbcTemplate to talk to db
	
	private static String INSERT_QUERY = """
			INSERT INTO COURSE (ID,NAME,AUTHOR)
			 VALUES(2,'learn AWS','in28Minutes');
			"""; 									// multiline string 
	
	public void insert() {
		// this is just a simple method with hardcoded values , we can also take id as parameter of function.
		courseJdbcTemplate.update(INSERT_QUERY);
	}
}
