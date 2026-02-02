//package com.Project.Todo.loginNotNeeded;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@Controller
//@SessionAttributes("username")
//public class LoginController {
//	
//	private AuthenticationService authenticationService; // But If we do not initailize this object it will be taken null => methods of this class can not be invoked.
//	// object initialize to karna pdega but If we want Spring to do this => Use Autowiring and Field Injection.
//	// We need to do autowiring => constructor injection.
//	// but for this AuthenticationService must be a bean.
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
//	
//	@RequestMapping(value="/login",method=RequestMethod.GET)
//	public String loginJSP() {
//		return "loginPage";
//	}
//
//
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String username,@RequestParam String password,
//								ModelMap model) {
//		if(authenticationService.authentication(username, password)) {
//			model.put("username", username);
//			return "welcomePage";
//		}
//		// else:
//		model.put("error", "This Accout Does Not exists Better SignIn first!!");
//		return "loginPage";
//		
//	}
//	
//}
