<html>
<head>
    <title>My Page</title>
</head>
<body>
    <h1>Welcome</h1>
    <p>This is a sample HTML page Using Jsp.</p>
</body>
</html>

<!--Notes Down /  -->
<!-- 
Your html can be rendered from here directly 
This Path is always fixed : src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp


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
 
 -->