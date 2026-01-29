package com.Prateek.rest.webservices.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

// this controller is to talk with your UserRepository for db implementation.

@RestController
public class UserJpaController {

	UserRepository repository; // I have connected User.java class already to db using @Entity
	PostRepository postRepository;
	
	public UserJpaController(UserRepository repo,PostRepository pr) {
		this.repository=repo;
		this.postRepository=pr;
	}
		
	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}

// HATEOAS
	@GetMapping(path = "/jpa/users/{userId}")
	public EntityModel<User> getSpecificUsers(@PathVariable int userId) {
		Optional<User> user = repository.findById(userId);
		
		if(user.isEmpty()) throw new UserNotFoundException("user Not found with id "+userId);

		EntityModel<User> entityModel = EntityModel.of(user.get()); // so we made an EntityModel of user object.
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers()); // this creates a link to findAll()
																					// method.
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	// Post Request is send along with data so we cant test it simply WITHOUT any
	// frontend or inputdata or TwoWayBinding
	// talend Api tester is used to send Api request - it is API tester chrome
	// extention

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User user1 = repository.save(user);
		// I want to return the URI location of our newly created user : i.e /users/id -
		// return this respose.
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	// whenever you create a new object using post request you should get its
	// location uri in response.

	@DeleteMapping(path = "/jpa/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		repository.deleteById(userId);
	}
	
	@GetMapping(path="jpa/users/{id}/posts")
	public List<Post> getPostsForAUser(@PathVariable int id){
		Optional<User> optUser = repository.findById(id);
		if(optUser.isEmpty()) throw new UserNotFoundException("User Not Found with id : "+id);
		
		User user = optUser.get();
		return user.getPosts();
	}
	
	@GetMapping(path="jpa/users/{id}/posts/{postId}")
	public Post getSpecificPostOfSpecificUser(@PathVariable int id,@PathVariable int postId) {

		// postId is itself a unique id.
		Optional<Post> post = postRepository.findById(postId);
		if(post.isEmpty()) throw new PostNotFoundException("Post Not Found with id : "+postId);

		// return this post only if belongs to current user.
		
		Optional<User> optUser = repository.findById(id);
		if(optUser.isEmpty()) throw new UserNotFoundException("User Not Found with id : "+id);
		User user = optUser.get();
		List<Post> posts = user.getPosts();
		boolean exists =
			    posts.stream().anyMatch(p -> p.getId().equals(post.get().getId() ));
		if(exists) return post.get();
		throw new PostNotFoundException("Current User has No post with id : "+postId);
		
	}
	
	// Post request : 
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@Valid @RequestBody Post post,@PathVariable int id) {
		
		Optional<User> optUser = repository.findById(id);
		if(optUser.isEmpty()) throw new UserNotFoundException("User Not Found with id : "+id);
		User user = optUser.get();
		
		post.setUser(user);
		
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
// this is the exact location of created post and it is correct.
		return ResponseEntity.created(location).build();
	}
	// whenever you create a new object using post request you should get its
	// location uri in response.
}
