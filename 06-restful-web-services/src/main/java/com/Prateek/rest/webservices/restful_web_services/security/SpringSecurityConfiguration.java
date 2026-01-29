package com.Prateek.rest.webservices.restful_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration 		// for spring to manage THIS CONFIGURATION/COMPONENT whatever	
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//1. all requests should be authenticated.
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
			);												// return 403. if not authorized.
		
		//2. show web page if not auth. but in restApi we show popUp for authn.
		// there is a class in Customizer -> withDefaults -> do its static import using qualified name.
		// httpBasic -> shows an basic popUp for authentication. 
		
		http.httpBasic(withDefaults());
		
		//3. disable crsf to allow write requests.
		http.csrf().disable();  // but still it works
		
		return http.build();
	}
	
}
