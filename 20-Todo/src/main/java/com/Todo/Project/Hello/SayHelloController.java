package com.Todo.Project.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// Notes: sayHelloControllerNotes.txt

@Controller		
public class SayHelloController{
	
	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello() {
		return "Hello what are you doing today!";
	}
	
	@RequestMapping("/sayHello-Html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<title>My Page</title>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("<h1>Welcome</h1>\n");
		sb.append("<p>This is a sample HTML page.</p>\n");
		sb.append("</body>\n");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("/sayHello-jsp")
	public String sayHelloJsp() {
		return "sayHello"; 		
	}
	// what is heppening here :- Spring View Resolver.
	
}
//        ############### NOTES DOWN / #################


/*
 * ResponseBody :=> when function returns a string it is not retured as ease 
 * SpringMVC looks for a view which it will not find as String is not returned as ease
 * ResposneBody indicates that method return value should be bound to web page's body. return value as ease.
 */

/*
 * 1. What is StringBuffer?

		StringBuffer is a mutable sequence of characters in Java.
		
		Unlike String, it can be modified
		
		It is thread-safe (synchronized)
		
		Used when multiple threads modify the same string
		
			StringBuffer sb = new StringBuffer("Hello");
			sb.append(" World");
			System.out.println(sb); // Hello World


 * 2. Why does StringBuffer exist?

		Because String is immutable.
		
			String s = "Hello";
			s.concat(" World");   // creates a new object of combined values i.e internally another string = "Hello World" is created.
		
		
		This wastes memory in loops or heavy string manipulation.
		
		StringBuffer solves this by modifying the same object.
 */

/*
 * JSP (JavaServer Pages) — clear, structured explanation
1. What is JSP?

	JSP (JavaServer Pages) is a server-side view technology used to generate dynamic HTML in Java web applications.
	
	In simple terms:
	
	JSP = HTML + embedded Java code executed on the server
	
	The browser never sees Java.
	It only receives final HTML.
	
 2. How JSP actually works (VERY IMPORTANT)

	JSP is NOT executed directly.
	
	Flow:
	
		Client requests a .jsp page
		
		Server converts JSP into a Servlet
		
		Servlet is compiled
		
		Servlet executes
		
		Generated HTML is sent to browser
	
	So internally:
	
		JSP → Servlet → HTML
 */








