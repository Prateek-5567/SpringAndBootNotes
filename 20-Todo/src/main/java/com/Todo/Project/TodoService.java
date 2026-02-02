package com.Todo.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

// If we have DataBase Then we do not need TodoService at all. all these services will be implemented using jpa.

/*
 This class is used to maintain static list of todos as its Static data 
(i.e Temp. Data that remains only till app restarts)
 Later we will use H2 and later MYSQL database also. */

@Service  // so that it becomes a bean 
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 0 ;
	// either you need a constructor or need to manually initialize all the fields in your bean.

	static { // static data is filled this way : inside a static block
		todos.add(new Todo(++todoCount,"in28Mins","Learn Aws", LocalDate.now().plusYears(1) , false) );
		todos.add(new Todo(++todoCount,"Prateek","Learn DSA", LocalDate.now().plusYears(1) , false) );
		todos.add(new Todo(++todoCount,"Prateek","Learn FullStack", LocalDate.now().plusYears(1) , false) );		
	}
	
	public List<Todo> findByUsername(String username){
		List<Todo> tempTodos = new ArrayList<>(); // this is how we initialize objects in java.
		for(var i:todos) {
			if( i.getUsername().equals(username) ) {
				tempTodos.add(i);
			}
		}
		return tempTodos;
	}
	
	public void addTodo(String username,String desc,LocalDate targetDate,Boolean done) {
		todos.add( new Todo(++todoCount,username,desc,targetDate,done) );
	}

	public void deleteById(int id) {
		// for deleting in java we use something called predicate ; Predicate is defined to check some condition.
		// our predicate checks => is some records for that id exists in storage then return true.
		Predicate<? super Todo>	predicate				// Todo here is Class name ; i.e each object will be Todo class type.
			= todo -> todo.getId() == id ;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		
		Predicate<? super Todo>	predicate				// Todo here is Class name ; i.e each object will be Todo class type.
		= todo -> todo.getId() == id ;					// We Must know predicate is used for comparision. ; predicate is Object of Predicate Class;
		
		// we can apply loop and simply find that Todo Object that matches id But I will do GandMastii
		
		// GandMasti = Functional Programming : -
		Todo todo_obj = todos.stream().filter(predicate).findFirst().get();  // .get() is imp to retrieve.
		return todo_obj;
	}

	public void updateTodo(int id,
			String userName,
			String description,
			LocalDate targetDate,
			boolean b) {
		
			Todo todo_obj = findById(id);
			todo_obj.setDescription(description);
			todo_obj.setDone(b);
			todo_obj.setTargetDate(targetDate);
			// no need to set id and username they can't be altered.
	}
}
