package com.Todo.Project.Hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamsAndModel {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("Demo")
	public String RequestParamAndModelMap(@RequestParam(required=false) String name, ModelMap model) {
		logger.debug("I want this printed at debug level; Name={}",name);
		logger.info("I want this printed at Info Level"); 
		logger.warn("I want this printed at warn Level");
		// logger works when your webpage is loaded ; If you Configure your app at debug level then info and warn logs will also be printed.
		
		model.put("name", name);
		return "Model";
	}
}

// Thoery : /
/*
 		@RequestParam String name

	Purpose: Extracts a request parameter from the HTTP request. (url se parameter extract krega)
	
	Meaning: Spring looks for a query parameter (or form field) named name.
	
	Example request:
		http://localhost:8080/Demo?name=Prateek
	
	What happens:
		name=Prateek is read from the URL.
	
		Value is automatically converted to String.
	
	If name is missing:
	
		By default, Spring throws 400 Bad Request.
	
	Reason: @RequestParam is required=true by default.
	
	So ,Use this form (important interview point):
	
		(@RequestParam(required = false) String name)
	
 */

/*
 *		 ModelMap model

	Purpose: Used to send data from the controller to the view (JSP / Thymeleaf).

	Internally:

		It is a Map<String, Object>.

			Key = attribute name
			
			Value = data

	Line:
		model.put("name", name);

	Meaning:
		Adds an attribute called "name" to the model.
		
		This attribute is accessible inside the view(ie.  JSP )
	
	Example in JSP:
	
		Hello ${name}
 */







