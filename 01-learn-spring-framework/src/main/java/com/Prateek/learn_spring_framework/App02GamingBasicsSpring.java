package com.Prateek.learn_spring_framework;

import com.Prateek.learn_spring_framework.game.GamingConsole;
import com.Prateek.learn_spring_framework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// in this file we are launching game and game runner as spring beans.

public class App02GamingBasicsSpring {
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
						(GamingConfiguration.class)
			){
			
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
			
		}		
	}
}
