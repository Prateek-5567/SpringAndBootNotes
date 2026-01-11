package com.Prateek.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

// in this file we are launching game and game runner as spring beans.

@Configuration 
@ComponentScan("com.Prateek.learn_spring_framework.game") // all components are at this path only.
public class AppGamingBasicsSpring {
	
//	@Bean
//	public GamingConsole game() {
//		var game = new PacMan();
//		return game;
//	} 
	// no need to create Bean for PacMan() as PacMan class is a component of Spring now.
	
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		var gameRun = new GameRunner(game);
//		return gameRun;
//	}
	// GameRunner ko b component bana dia spring ka apne aap @Bean ban jayega and always return an instance of same
	// i.e GameRunner ka Bean bana to vo GameRunner ka hi instance return kar raha hoga.
	
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(AppGamingBasicsSpring.class)
			){
			
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
			
		}		
	}
}

// now we are not manually creating the beans still the code is working as spring is managing the beans for us.
