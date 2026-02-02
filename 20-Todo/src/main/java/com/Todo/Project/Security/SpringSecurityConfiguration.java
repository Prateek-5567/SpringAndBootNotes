package com.Todo.Project.Security;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	
	// The constructor of UserDetails is like : UserDetails(userDetails... user) 
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailManager() {
		
		String username = "Prateek";
		String password = "123456";
		String username2= "User1";
		String password2= "123456";
		
		UserDetails userDetails = createNewUser(username, password);
		UserDetails userDetails2 = createNewUser(username2, password2);
		
		return new InMemoryUserDetailsManager(userDetails,userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String,String> passwordEncoder =
				input -> passwordEncoder().encode(input);
				
		
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username(username)
									.password(password)
									.roles("USER","ADMIN")
									.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// BCryptPasswordEncoder is the class that used UserDetails interface internally so We are returning the instance of that class to 
	// use the services provided by UserDetails;
	
	
	/* SecurityFilterChain : Defines a filter chain matached against every request.
	 SecurityFilterChain is a class 
	* I have created a function whose return type is that `SecurityFilterChain` class instance. 
	* HttpSecurity allows us to configure web based security . By default it will be applied to all request i.e I we do not seprately manage it then.
	* However we are manually implementing the same thing  
	* Note : when we overRide SecurityFilterChain we need to define entire chain again. ; Do nothing or Do everything.
	* Note : entire DSL moved to lambda-based configuration. This is how it is done now:
	* http.<feature>(feature -> feature.<subfeature>(sub -> sub.disable()))
	* If Xframes options is Enabled = frames can not be used.
	* H2Console uses Frames so => Disable Xframes;
	*/
	
	@Bean		 //  you want spring to auto configure OBV. Yes
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
					auth -> auth.anyRequest().authenticated() ); // ye andar predicate define kia h .
		
		http.formLogin(withDefaults()); // configure login form  ; withDefaults is a static method defined in Coustomizer class 
		
		http.csrf(csrf -> csrf.disable()) ; // cross site request forgery is disabled ; entire DSL moved to lambda-based configuration.
		http.headers(headers -> headers.frameOptions( frame -> frame.disable()));  // earlier it was just http.headers().frameOptions().disable()
		
		return http.build();
	}
}


/*
 Q : Why it is annotated as @Configuration directly not @Service or @Component;
 A : @Service and @Component - Spring auto Configures the bean
 but here we want to create a number of diffrent beans so need to keep it manual.
 
 Q : What is Lambda FUnction and How it works. \/
 
 passwordEncoder (1st vala) is a Functional Interface that defines what passwordEncoder() should do
 	It takes some String input and passIt to whatever is the output of passwordEncoder() function to encode it.
 		i.e to BCryptPasswordEncoder() .
 		
 		/////
 	UserDetails userDetails = User.builder()
								.passwordEncoder(passwordEncoder)
								.username("Prateek")
								.password("123456")
								.roles("USER","ADMIN")
								.build();
								
	This is the Builder Pattern with method chaining.
	It works because each method returns the same object, allowing calls to be chained with dots.

	User comes from Spring Security 
	User.builder() creates a builder object on which we apply other methods in a chain to build final user.
 */
