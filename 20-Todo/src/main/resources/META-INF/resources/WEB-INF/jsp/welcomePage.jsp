<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!-- 	What it is line above:-
It is a JSP directive.
It tells the JSP compiler:
	“This page will use JSTL Core tags defined at this URI.”
 -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <style>
	   body {
	    margin: 0;
	    padding: 0;
	    font-family: Arial, Helvetica, sans-serif;
	    background: linear-gradient(
	        180deg,
	        #0f2027 0%,
	        #203a43 50%,
	        #2c5364 100%
	    );
	    min-height: 100vh;
	    color: #ffffff;
	
	    /* key changes */
	    display: flex;
	    flex-direction: column;
	}
	
	/* wrapper to center content below navbar */
	.welcome-wrapper {
	    flex: 1;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	}
	
	.welcome-box {
	    background-color: rgba(255, 255, 255, 0.08);
	    padding: 40px 60px;
	    border-radius: 12px;
	    text-align: center;
	    box-shadow: 0 12px 30px rgba(0,0,0,0.4);
	    backdrop-filter: blur(6px);
	}
	
	h1 {
	    margin-bottom: 15px;
	    font-size: 36px;
	    letter-spacing: 1px;
	}
	
	p {
	    font-size: 18px;
	    margin-bottom: 30px;
	    color: #e0e0e0;
	}
	
	.anchor {
	    padding: 10px 28px;
	    font-size: 16px;
	    border-radius: 6px;
	    background-color: #4dd0e1;
	    color: #00363a;
	    font-weight: bold;
	    text-decoration: none;
	}
	
	.anchor:hover {
	    background-color: #80deea;
	}

    </style>
</head>
<body>

	<jsp:include page="navbar.jsp" />
	
	<div class="welcome-wrapper">	
    <div class="welcome-box">
        <h1>Welcome ${username }</h1>
        <p>You have successfully logged in.</p>
        <a href="list-todos" class="anchor"> Get Started</a>
       <!-- you may use href="${pageContext.request.contextPath}/list-todos" also  -->
    </div>
    </div>

</body>
</html>
