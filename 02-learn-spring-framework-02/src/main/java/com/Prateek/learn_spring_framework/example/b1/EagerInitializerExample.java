package com.Prateek.learn_spring_framework.example.b1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;

@Component
class ClassA{
	
}
@Component
// by default it is Eager initializer
class ClassB{
	private ClassA classA;
	
	//@Autowired : optional
	public ClassB(ClassA classA) {
		// some initialization logic is called here,
		System.out.println("Some initialisation logic is performed");
		System.out.println("I will not create the object of this class still the constructor will be called and initialisation will be done : Its Eager Initializer.");
		this.classA = classA;
	}
}


@Configuration 
@ComponentScan  // by default it scan current package.
public class EagerInitializerExample {
	
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(EagerInitializerExample.class)
			){
			
			// I am not doing anything still the dependencies(Constructor based) are called.
			
		}		
	}
}

