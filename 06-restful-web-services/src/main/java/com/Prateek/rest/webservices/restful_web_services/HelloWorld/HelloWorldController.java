package com.Prateek.rest.webservices.restful_web_services.HelloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}


	@GetMapping(path="hello-world") // value or path both goodToGo.s
	public String HelloWorld() {
		return "Hello World";
	}
	
	
	@RequestMapping(value="hello-world-bean",method=RequestMethod.GET)
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("This was the message");
	}
	
	@GetMapping(path="/helloWorld/PathMapping/{name}")
	public HelloWorldBean helloWorldPathMapping(@PathVariable String name) {
		// @RequestParam is also a way to access values from url but those are like user/id=?pass=? type parameters.
		StringBuilder sb=new StringBuilder();
		sb.append("This was the message , ");
		sb.append(name);
		return new HelloWorldBean(sb.toString());
	}
	
/*	@GetMapping(path="users/{userId}/todos/{todoId}")
	public HelloWorldBean userMethodPathMapping(@PathVariable Integer userId,@PathVariable Integer todoId ) {
		// @RequestParam is also a way to access values from url but those are like user/id=?pass=? type parameters.
		StringBuilder sb=new StringBuilder();
		sb.append("User id : ");
		sb.append(userId);
		sb.append(",Todo id : ");
		sb.append(todoId);
		return new HelloWorldBean(sb.toString());
	}
*/
	
	
	@GetMapping(path="hello-world-i18n") // value or path both goodToGo.s
	public String HelloWorldI18n() {
		Locale locale = LocaleContextHolder.getLocale();  // it gives you the locale associated with current thread.
		return messageSource.getMessage("greetings.message", null, "Default msg", locale);
	}
	
}
