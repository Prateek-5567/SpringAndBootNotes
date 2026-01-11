package com.Prateek.learn_spring_framework.example.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;
	public SomeClass(SomeDependency someDependency) {
		super();
		System.out.println("All dep. are wired.");
		this.someDependency=someDependency;
	}
	
	@PostConstruct
	public void initialization() {
		// I will not call this method ever in main() still PostConstruct will run. => Spring will call it.
		someDependency.initialize();
		// this is PostConstruct method : autoRuns after dependencies are wired.
	}
	
	
	
}
@Component
class SomeDependency{
	
	public void initialize() {
		// write your initialization logic : Db connections setup ; validate the dependencies etc.
		System.out.println("Initialization logic ; Beans created ; I am auto called after constructor has done execution.");		
	}
	
	@PreDestroy
	public void Cleanpup() {
		System.out.println("runs before beans destroy.");
	}
	
}

@Configuration @ComponentScan
public class PostPreAnnotationsLauncherApplication {
	public static void main(String[] args){
		// without 'String[] args ' => it wont run.
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(PostPreAnnotationsLauncherApplication.class) ){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
	
}
