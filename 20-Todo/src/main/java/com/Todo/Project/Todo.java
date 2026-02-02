package com.Todo.Project;

import java.time.LocalDate;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Map Todo Bean - Database Table ( using spring-data-jpa )

@Entity
public class Todo {
	@Id
	@GeneratedValue  // to generate seq. of values.		Database generates the ID (AUTO_INCREMENT)
	private int id;
	
	private String username;
	
	@NotBlank(message = " Description can not be blank")
	@Size(min=5,message="Description Size must be atleast 5")
	private String description;
	
	private LocalDate targetDate;		
	private boolean done;
	
	public Todo() {
		// default constructor for entity is very much req. as while creating object we sometimes might not pass those username & all args so If You want Spring to manage This fullfill all requirements.
	}

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}

// we already know : topopulate some data on startup - data.sql in java main resources
