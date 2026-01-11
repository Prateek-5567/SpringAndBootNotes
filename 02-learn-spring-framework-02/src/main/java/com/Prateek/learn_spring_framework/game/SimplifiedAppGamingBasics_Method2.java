package com.Prateek.learn_spring_framework.game;
// SEE HOW SIMPLIFIED IT IS NOW TO MANAGE CLASSES 

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;


@Configuration 
@ComponentScan("com.Prateek.learn_spring_framework.game")
public class SimplifiedAppGamingBasics_Method2 {
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(AppGamingBasicsSpring.class)
			){
			
			
			context.getBean(GameRunner.class).run(); // game Runner knows ki pacman run karna h .
			
			context.getBean("contra",GamingConsole.class).up();
		}		
	}
}
