package com.Todo.Project.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		model.put("username", getAuthenticatedUsername());				// Session ke andar model name yahi se ara h
		return "welcomePage";
	}
	
	public String getAuthenticatedUsername() {
		// object of Authentication class
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
