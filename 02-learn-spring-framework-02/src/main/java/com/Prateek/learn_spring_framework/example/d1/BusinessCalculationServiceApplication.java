package com.Prateek.learn_spring_framework.example.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // scan current package for Component / Specialisations of @Component
public class BusinessCalculationServiceApplication {
	
	public static void main(String[] args) { 
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(BusinessCalculationServiceApplication.class)) {
			
			int maxi = context.getBean(BusinessCalculationService.class).findMax();
			System.out.println(maxi);
			
			// How to run MqSql db class :  (no need to import dataService class as it is currentPackage.)
			dataService mysql = context.getBean("MySql",dataService.class);
			BusinessCalculationService obj1 = new BusinessCalculationService(mysql);
			System.out.println(obj1.findMax());
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);;
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("there is some error");
		}
		
		// EveryThing works same as example.a2
	}
}

