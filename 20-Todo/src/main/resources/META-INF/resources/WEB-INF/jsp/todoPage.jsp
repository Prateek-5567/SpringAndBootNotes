<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Todos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/todoPageStyle.css">
    
</head>

<body>
<!-- To Include another jsp file here you use :  -->
	<jsp:include page="navbar.jsp" />
<!-- To import jspf use this line od code -->
<!-- 	< %@ include file="navbar.jspf" % > -->

    <div class="containerr">
        <h1>Hi ${username}, Your Todos - </h1>

        <table>
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is it Done?</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
            
              <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description }</td>
                    <td>${todo.targetDate }</td>
                    <td>${todo.done }</td>
                    <td><a href="update-todo?id=${todo.id}"><button class="btnn btnn-update">Update</button></a></td>
                    <td><a href="delete-todo?id=${todo.id}"><button class="btnn btnn-delete">Delete</button></a></td>
                </tr>
              </c:forEach>

<!-- href="delete-todo?id=${todo.id}" this is how we are sharing the id of Todo over files => using the url and accept it using @RequestParam in controller. -->

            </tbody>
            
        </table>

	        <a href="add-todo">
		        <button class="btnnAddTodo btnn-update">
		        	Add Todo
		        </button> 
	        </a>

    </div>

</body>
</html>
