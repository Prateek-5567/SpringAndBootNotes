<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Todo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addTodoPage.css">
	<link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	<!-- above line is to integrate bootstrap  -->
	<link rel="stylesheet" href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css">
	<!-- above line is to integrate bootstrap-datepicker  -->
</head>
<body>

<div class="containerr"> 
<!-- used class=containerr because container with single 'r' is a builtIn bootstrap class and that will override your class otherwise and I want coustom css -->
    <h1>Add Todo</h1>

    <form:form method="post" modelAttribute="todo">
		
		<fieldset>
	        <label for="desc">Description</label>
	        <form:input
	                path="description"
	                id="desc"
	                placeholder="Enter todo description"
	                autocomplete="off"
	                autocapitalize="off"
	                spellcheck="false"
	                cssClass="input"
	        />
	        <form:errors path="description" cssClass="error"/>
        </fieldset>
        
        <fieldset>
	        <form:label for="date" path="targetDate">Target Date</form:label>
	        <form:input
	                path="targetDate"
					id="date"
	                placeholder="Enter todo TargetDate"
	                autocomplete="off"
	                autocapitalize="off"
	                spellcheck="false"
	                cssClass="input"
	        />
	        <form:errors path="targetDate" cssClass="error"/>
        </fieldset>
        
        <form:input 
        	type="hidden"
        	path="id"
        	placeholder="enter id"
        	autocomplete="off"
        	autocapitalize="off"
            spellcheck="false"
        />
        <form:input 
        	type="hidden"
        	path="done"
        	placeholder="is done"
        	autocomplete="off"
        	autocapitalize="off"
            spellcheck="false"
        />
        <!-- I just added id and done fields to ensure to are not left null and no error is hence rased => try removing them => error. -->

        <button class="mt-3" type="submit">Save</button>

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