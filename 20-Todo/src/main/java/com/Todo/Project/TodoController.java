package com.Todo.Project;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

// THIS IS FOR TODO_SERVICE USED WHEN TODO.JAVA WAS NOT A @ENTITY OF A DATABASE.

//@Controller   : By commenting this out this is no longer managed by spring so it is no longer a controller .
@SessionAttributes("username")
public class TodoController {
	
	private TodoService todoService; //  auto initialize using Spring Beans
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping(value="/list-todos")
	public String getAllTodos(ModelMap model) {
		String UserName = (String)model.get("username");
		List<Todo> todos = todoService.findByUsername(UserName);
		model.put("todos", todos); 									// model is a HashMap : String -> Object
		return "todoPage";
	}
	
	
// ########## 	ADD_NEW TODO : 	
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String addTodoGet(ModelMap model) {
		String UserName= (String)model.get("username");
		Todo todo = new Todo(0,UserName,"",LocalDate.now(),false);  //  whatever is set here is considered the default value for addTodo page because of validation concept. (It can be modified.)
		model.put("todo", todo);
		return "addTodo";
	}
	
// On Get request phase we must send a todo in our model. GET defines the default values of mapped fields.
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addTodoPost(
			ModelMap model,
			@Valid @ModelAttribute("todo") Todo todo,
			BindingResult result) { 	
		
		if(result.hasErrors()) { 
			return "addTodo";
			//return "redirect:list-todos";
			} // Manage Errors. // If you redirect = Validation errors are lost ; So you just return JSP file name and remain on same page to see errors.
		
		String UserName= (String)model.get("username");
		todoService.addTodo(UserName, todo.getDescription() , todo.getTargetDate(), false);
		return "redirect:list-todos";
	} 
	
	/* @Valid is necessary; @Valid triggers internal validation what all you have defined in Todo.java class.
	 -> BindingResult is used to Prevent the error Page "White Label Error" ; We dont want to show a separate page to display errors We want to show it on same page => so you need to manage it.
	 -> POST defines internal Mapping ; taking values from webPage and connecting to CLASS and saving it internally like DB
	 -> this todoDesc is a from parameter so @RequestParam will pick it from payload. // when from submit to POST request there is a data Payload.	
	 -> whenever the addTodo from hits a POST request redirect it to list-todos page .
	 -> doing return todoPage from here is wrong cuz you need to  load the data of todoPage before returning which is redundant step to do again.
	*/

	
// ########## 	DELETE TODO : 
	
	@RequestMapping(value="delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	// the above 4 lines means : whenever there is a call to /delete-todo url then deleteTodo() method is executed and flow is redirected to /list-todos 	;
	
	
// ########## 	UPDATE TODO Functionality : -
	
// GET request : used to show the page to user.
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model,@RequestParam int id) {
		Todo todo_obj = todoService.findById(id);
		model.addAttribute(todo_obj); // add the required todo_object to model and we will update it.
		return "updateTodo";
	}
	
// POST method : is used to collect data , save changes , do validation and redirect to list-todos.
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodoPOST(
				@RequestParam int id,
				@Valid Todo todo, 			 				 		//<!-- ` modelAttribute="todo" ` : this is how we link @Valid Todo todo to updateTodo page --> and we take all fields from user where path maps them to exact Todo.class variables.
				BindingResult result,
				ModelMap model) { 
			
			if(result.hasErrors()) {return "update-todo";} 			// we have applied some constraints in Todo.java that are triggred using @Valid and must be obeyed. Moreover If there are errors we remain on same page and display them using jstl;
			
			String UserName= (String)model.get("username");
			todoService.updateTodo(id,
					UserName,
					todo.getDescription() ,
					todo.getTargetDate(), 
					todo.getDone());
			return "redirect:list-todos";
		}
	
// How Am I able to get the actual updated values this way :-> because Two Way Binding feature provided BY Spring MVC Maps ; How Linking Mechanism Works ? 
// why i am using redirect:-> because i cant directly return to todoPage.jsp before loding the data from backend so better I redirect to /list-todos url so that the method which is mapped to /list-todos url gets executed.
	

}
