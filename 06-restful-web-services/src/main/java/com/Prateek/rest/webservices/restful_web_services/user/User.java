package com.Prateek.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")  		// there is a keyword in H2 db by name user so you cant have an entity with same name.
public class User {
	
	@Id @GeneratedValue 		// this is for DB 	and no need to pass id field in post request now.
	@NotNull	
	private int id; 
	
	@NotNull
	@Size(min=2,message = "Minimum Size >= 2 chars")
	@Column
	private String name;
	
	@NotNull
	@Column
	@JsonProperty("DateOfBirth")				// It IS ACTUALLY RENAMED NOW. NOW YOU NEED TO SEND POST REQUEST TO DateOfBirth not to dob.
	@Past(message = "dob must be in past")		// dob must be in past.
	private LocalDate dob;
	
	@OneToMany(mappedBy="user")					// one User has Many posts.
	@JsonIgnore									// when user goto /users at that time I do not want to display the list of Posts also ; Posts are linked to a specific user accessible via /user/101/posts
	private List<Post> posts;
	
	public User() {} // no arg. constructor is necessary to create empty object of user.
	
	public User(int id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	
}
