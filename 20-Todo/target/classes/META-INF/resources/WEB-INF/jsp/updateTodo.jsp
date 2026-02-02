<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <!-- we have a model attribute = ${todo_obj} i.e our target todo object to update through ModelMap -->

<!DOCTYPE html>
<html>
<head>
    <title>Update Todo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addTodoPage.css">
	<link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	<!-- above line is to integrate bootstrap  -->
	<link rel="stylesheet" href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css">
	<!-- above line is to integrate bootstrap-datepicker  -->
</head>
<body>

<div class="containerr">
    <h1>Update Todo</h1>

    <form:form method="post" modelAttribute="todo" >
    <!-- this is how we link Controller method to updateTodo page,
     by providing the Attributed that we puted in model for this page-->

        <!-- Description -->
        <div class="form-group">
		    <form:label path ="description" >Description</form:label>
		    <form:input
		        path="description"
		        cssClass="input"
		        placeholder="Update todo description"
		    />
		    <form:errors path="description" cssClass="error" element="div"/>
		</div>
		
<!-- IMPORTANT :  here path is what maps your input field directly to your Todo.java class parameters
	This comes under CommandBean Concept in Spring MVC -->
	
		<!-- Target Date -->
		<div class="form-group">
		    <form:label for="date" path="targetDate">Target Date</form:label>
		    <form:input
		        path="targetDate"
		        id="date"
		        cssClass="input"
		        placeholder="Update target Date"
		    />
		    <form:errors path="targetDate" cssClass="error" element="div"/>
		</div>
		
    	<!-- Done Dropdown -->
        <div class="form-group">
		    <label for="done">Status</label>
		    <form:select path="done" id="done" cssClass="input">
		        <form:option value="false">Not Done</form:option>
		        <form:option value="true">Done</form:option>
		    </form:select>
		</div>

        <!-- Hidden fields (required for update cuz you cant left them unused) -->
        <form:hidden path="id"/>
        <form:hidden path="username"/>

        <button type="submit">Update</button>

    </form:form>
</div>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js" > </script>
	<script type="text/javascript" src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
	// targetDate is field name and it is for element whose id = "targetName" so I have used #
		$('#date').datepicker({
			format:"yyyy-mm-dd"
		});
	</script>
</body>
</html>

 <!-- This path is for js file of datePicker pop-up ; AND as usual you can trim it upto /resources  -->
<!-- 	/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js  -->

 <!-- This path is for js file of bootstrap pop-up ; AND as usual you can trim it upto /resources  -->
<!-- /META-INF/resources/webjars/bootstrap/5.3.3/js/bootstrap.min.js -->