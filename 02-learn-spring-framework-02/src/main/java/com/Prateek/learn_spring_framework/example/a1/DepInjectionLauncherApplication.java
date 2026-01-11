package com.Prateek.learn_spring_framework.example.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;

@Component
class YourBuisnessApplication{
	// this is how you inject Dependency in your class : 
	
//	@Autowired  // : this is called field injection
	Dependency1 dep1;
//	@Autowired
	Dependency2 dep2;
	
//	@Autowired // it is optional to write @Autowired in constructor injection.
	public YourBuisnessApplication(Dependency1 dep1,Dependency2 dep2){
		System.out.println("constructor injection called.");
		this.dep1 = dep1;
		this.dep2 = dep2; 
	}
	
//	@Autowired // this is called Setter Based injecetion;
	public void setDep1(Dependency1 dep1) {
		System.out.println("Setter1 injection called.");
		this.dep1 = dep1;
	}
//	@Autowired
	public void setDep2(Dependency2 dep2) {
		System.out.println("Setter2 injection called.");
		this.dep2 = dep2;
	}



	// whenever you do 'System.out.println(YourBusinessApplication)' : then toString() method auto executes. 
	public String toString() {
		return "Using "+dep1+" and "+dep2; 
	}
	
}
@Component
class Dependency1{
	
}
@Component
class Dependency2{
	
}

@Configuration 
@ComponentScan  // by default it scan current package.
public class DepInjectionLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(DepInjectionLauncherApplication.class)
			){
			
			// if you want to see what beans are part of the spring context launched above then:
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			// DepInjectionLauncherApplication will also be a bean. for this is the configuration class here.  
		
		
			// if you dont use @Autowired on dependencies they will not get injected (try this) :-> This type of injection is Field Injection.
			// remove @Autowired from fields and put @Autowired before setters of each field :-> then it is called Setter Based injection.
			// remove @Autowired from Setters also and put it over constructor => then it is called Constructor based. 
			// it is not necessary to write @Autowired before constructor (be default hota hi h Constructor based dependency injection).
			
			System.out.println(context.getBean(YourBuisnessApplication.class));
		}		
	}
}

