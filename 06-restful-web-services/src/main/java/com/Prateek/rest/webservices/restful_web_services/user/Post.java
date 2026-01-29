package com.Prateek.rest.webservices.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
	
	@Id 
	@GeneratedValue			// auto generated.
	private Integer id;
	
	@Size(min=2)
	@NotNull
	private String description;
	
	@ManyToOne					//	many posts corresponds to same user is possible.
	@JsonIgnore					// why to avoid it in JsonResponse - Same Reason.
	private User user;			// what does this store ? 	
	
	public Post() {  // an entity must have it ; Will be definately required.
		super();
	}

	public Post(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	
	
	
}
