package com.Prateek.learn_spring_framework.example.a0;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;


@Configuration 
@ComponentScan  // by default it scan current package.
public class SimpleSpringLauncherApplication {
	

	
	
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(SimpleSpringLauncherApplication.class)
			){
			
			// if you want to see what beans are part of the spring context launched above then:
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			// DepInjectionLauncherApplication will also be a bean. for this is the configuration class here.  
		}		
	}
}

