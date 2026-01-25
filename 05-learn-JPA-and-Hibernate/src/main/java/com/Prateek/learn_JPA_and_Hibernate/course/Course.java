package com.Prateek.learn_JPA_and_Hibernate.course;

public class Course {
	private int id;
	private String name;
	private String author;

	public Course() {
	}

	/// why do we need a no arg constructor ;
	// in CourseJdbcCommandLineRunner you have used Course course ; it invokes a
	// no-arg constructor so you must provide it,

	public Course(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Course(int id) {
		super();
		this.id = id;
		this.name = null;
		this.author = null;
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
