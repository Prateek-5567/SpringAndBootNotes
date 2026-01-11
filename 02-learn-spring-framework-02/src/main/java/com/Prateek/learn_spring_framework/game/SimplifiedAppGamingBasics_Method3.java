package com.Prateek.learn_spring_framework.game;
// SEE HOW SIMPLIFIED IT IS NOW TO MANAGE CLASSES 

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;


@Configuration 
@ComponentScan("com.Prateek.learn_spring_framework.game")
public class SimplifiedAppGamingBasics_Method3 {
	
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(AppGamingBasicsSpring.class)
			){// this is called try-with-response.
			
				GamingConsole mario = context.getBean("mario", GamingConsole.class);
		        GamingConsole pacman = context.getBean("pacman", GamingConsole.class);
		        GamingConsole contra = context.getBean("contra", GamingConsole.class);
	
		        new GameRunner(mario).run();
		        new GameRunner(pacman).run();
		        new GameRunner(contra).run();
		}		
	}
}
