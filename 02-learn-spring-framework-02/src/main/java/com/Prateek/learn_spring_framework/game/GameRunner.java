package com.Prateek.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
//	private SuperContra game; if i use this code then game object -
//	- is tightly coupled to SuperContra but as SuperContra implements -
//	GamingConsole completely and no extra methoda specific to SuperContra -
//	is being used in GameRunner , so I can directly use GamingConsole Interface to create object here 
//	that object will work for MarioGame, SuperContra , PacMan all three as all implements GamingConsole.
	
	private GamingConsole game;
	
	public GameRunner(@Qualifier("pacman") GamingConsole game){
		this.game=game;
	}
	// 2nd method : Specify which game you want to run in GameRunner constructor using Qualifier.
	
	public void run(){
		System.out.println("Game Running ! " );
		game.down();
		game.right();
		game.up();
		game.left();
	}
// methods : up left right down all are three in GamingConsole that are further 
//	implemented by the class jiska object ham GameRunner me run hone ke lie bejenge

}
