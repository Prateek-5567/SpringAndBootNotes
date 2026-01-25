package com.Prateek.learn_spring_boot_Configuration_Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// this is not normal REST-API it is special : it is managing Complex Configuration for diffrent environments
// IMP : THE CONFIGURATION CLASS IN THIS APPLICATION MUST BE A BEAN ; so mark @Component.
// This file acts as centralised class for all application related configurations.

@ConfigurationProperties(prefix = "complex-service")
@Component
public class ComplexServiceConfiguration {
	private String url;
	private String username;
	private String key;
	
	public ComplexServiceConfiguration() {
		// this is no-arg constructor ; why it is needed .? 
	}

	public ComplexServiceConfiguration(String url, String username, String key) {
		super();
		this.url = url;
		this.username = username;
		this.key = key;
		// either remove this constructor or add a no-arg constructor.
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "ComplexServiceConfiguration [url=" + url + ", username=" + username + ", key=" + key + "]";
	}
	
	

}

// Why No Arg constructor 
/*
 * ❌ Problem : @ConfigurationProperties class is WRONG

Your class ComplexServiceConfiguration has only a parameterized constructor .

Spring Boot cannot bind properties like this unless you explicitly use constructor binding.

What Spring expects by default

For @ConfigurationProperties, Spring expects:

	1. A no-args constructor,
	2. setters to inject values

You violated that rule.

Result

The bean is created, but properties are NOT injected, leading to any of :
	null values
	serialization issues
	confusing “API not working” behavior
	
If you want default injections of Spring-boot to work you will have to stick to rules syntax and defined ways.
 */
