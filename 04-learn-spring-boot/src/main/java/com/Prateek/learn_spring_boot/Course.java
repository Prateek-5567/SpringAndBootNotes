package com.Prateek.learn_spring_boot;

public class Course {
	// If you want Spring Boot to do auto wiring for you then your class must follow this standard structure :
	// .. it must have  constructor , getters ,toString
	private long id;
	private String name;
	private String author;
	
	// we need constructor , getters , and toString (I must know what toString does) 
	// when you print(Courses.class) toString runs.

	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
}
