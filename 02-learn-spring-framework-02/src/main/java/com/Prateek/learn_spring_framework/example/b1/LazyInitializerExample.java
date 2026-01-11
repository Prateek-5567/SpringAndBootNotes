package com.Prateek.learn_spring_framework.example.b1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;

@Component
class ClassC{
	
}
@Component
@Lazy 
class ClassD{
	private ClassC classC;
	
	//@Autowired : optional
	public ClassD(ClassC classC) {
		// some initialization logic is called here,
		System.out.println("Some initialisation logic is performed");
		System.out.println("In case of Lazy Initializer : Initialiation of Bean only occurs you will use classD bean");
		this.classC = classC;
	}
	
	@Autowired
	public ClassC getClassC() {
		System.out.println("i am a dependency of ClassD and I am executed .");
		return classC;
	}

}


@Configuration 
@ComponentScan  // by default it scan current package.
public class LazyInitializerExample {
	
	
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(LazyInitializerExample.class)
			){
			// if you comment the next line then initalizer of Beans will not be called as it is Lazy Initializer.
				System.out.println(context.getBean(ClassD.class)); // jab Beans use karoge tabhi initialization hoga => only then Dependencies will be executed.
				// kul mila ke => When Bean is accessed then only its dependencies are compiled/executed.
				
				/*
				 * Lazy initialization is a technique where an object is created only when it is first needed, not at the time the program starts.
				 * Eager : object is created when program start so all dependcies are also configuired.
				 * eager initialization is recommended as errors in Configuration are configured immediately at application startup.
				 * 
				 * you may alson use @Lazy(value=true) to add Lazy initialization annotation.
				 * */
		}		
	}
}

