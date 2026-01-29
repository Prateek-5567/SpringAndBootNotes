package com.Prateek.rest.webservices.restful_web_services.user;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component				// so it to be managed by spring
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int id=100;
	
	static {
		users.add(new User(++id,"Adam",LocalDate.now().minusYears(25)));
		users.add(new User(++id,"Eve",LocalDate.now().minusYears(22)));
		users.add(new User(++id,"Bob",LocalDate.now().minusYears(21)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int id) {
		
		Optional<User> optionalUser =
		        users.stream().filter(u -> u.getId() == id).findFirst();

		if (optionalUser.isEmpty()) {
		    throw new UserNotFoundException("User Not Found with id : "+id);
		}
		
		User user = optionalUser.get();
		    						 // link to value hogai kuch key bhi to batao therefore we add relation also.
		return user;

	}
	
/* 	Another good approach is using : orElseThrow to throw exception.
	public User findById2(int id) {
	    return users.stream()
	            .filter(user -> user.getId() == id)
	            .findFirst()
	            .orElseThrow(() ->
	                new UserNotFoundException("User Not Found with id : " + id)
	            );
	}
*/
	
	public User save(User user) {
		user.setId(++id);
		users.add(user);
		return user;
	}
	public void deleteById(int id) {
		
		users.removeIf( u -> u.getId()==id );  // this is shorthand predicate in modern java.

	}   // here predicate = user -> user.getId()==id ;
	
}

/*
1. I want a list of users to be maintained. 
  : Initally we can use a static list later get database implemented ( H2 , Mysql)

*/