package com.Prateek.rest.webservices.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserDaoService userDaoService;  // # autowired.
	public UserController(UserDaoService userDaoService) { // constructor injection is imp.
		super();
		this.userDaoService=userDaoService;
	}
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	
// HATEOAS
	@GetMapping(path="/users/{userId}")
	public EntityModel<User> getSpecificUsers(@PathVariable int userId){
		User user = userDaoService.findById(userId);
		EntityModel<User> entityModel = EntityModel.of(user); 						// so we made an EntityModel of user object.
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers() );  // this creates a link to findAll() method.
		entityModel.add(link.withRel("all-users")); 
		return entityModel;
				
	}
	
	// Post Request is send along with data so we cant test it simply WITHOUT any frontend or inputdata or TwoWayBinding
	// talend Api tester is used to send Api request - it is API tester chrome extention 
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser( @Valid @RequestBody User user){ 
		User user1= userDaoService.save(user);
		// I want to return the URI location of our newly created user : i.e /users/id  - return this respose.
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(user1.getId())
												  .toUri();
		
		return ResponseEntity.created(location).build();
	} 
	//whenever you create a new object using post request you should get its location uri in response.
	
	@DeleteMapping(path="/users/{userId}")
	public void deleteUser(@PathVariable int userId){
		userDaoService.deleteById(userId);
	}

	
}
