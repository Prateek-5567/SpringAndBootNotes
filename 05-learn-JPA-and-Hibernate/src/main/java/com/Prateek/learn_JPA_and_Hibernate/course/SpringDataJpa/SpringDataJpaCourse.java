package com.Prateek.learn_JPA_and_Hibernate.course.SpringDataJpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// JPA : Java Persistance API

// I have commented out course.jpa cuz at a time only one Entity mapping to a particular class can be done.
// this class is mapped to our course table for Now. 


@Entity(name="Course")
public class SpringDataJpaCourse {
	
	@Id			// name matches directly need not specify (name="Id") separately ; same for @Column
	private int id;
	
	@Column
	private String name;
	
	@Column(name="author")  // optional to specify name 
	private String author;

	public SpringDataJpaCourse() {
	}

	/// why do we need a no arg constructor ;
	// in CourseJdbcCommandLineRunner you have used Course course ; it invokes a
	// no-arg constructor so you must provide it,

	public SpringDataJpaCourse(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id = " + id + ", name = " + name + ", author = " + author + "]";
	}

}
