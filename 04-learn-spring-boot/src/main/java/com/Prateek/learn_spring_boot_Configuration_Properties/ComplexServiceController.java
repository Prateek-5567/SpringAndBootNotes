package com.Prateek.learn_spring_boot_Configuration_Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplexServiceController {
	
	@Autowired // Component hai to Autowire bhi krna pdega in spring.
	private ComplexServiceConfiguration configuration;
	
	@RequestMapping("/complex-configurations")
	public ComplexServiceConfiguration retrieveAllData() {
		return configuration;
	}
	// but ye configuration object me values kon dalega  : Programmer => using application.properties 
	
	
}
 