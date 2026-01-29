package com.Prateek.rest.webservices.restful_web_services.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException{
	
	public PostNotFoundException(String message){
		super(message); // this way we can pass some message to the super class.
	}
}
