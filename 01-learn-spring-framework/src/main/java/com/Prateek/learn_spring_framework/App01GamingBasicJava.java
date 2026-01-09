package com.Prateek.learn_spring_framework;

import com.Prateek.learn_spring_framework.game.GameRunner;
import com.Prateek.learn_spring_framework.game.MarioGame;
import com.Prateek.learn_spring_framework.game.PacMan;
import com.Prateek.learn_spring_framework.game.SuperContra;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		var game1 = new MarioGame(); // 1. Object Creation
		var game2 = new SuperContra();
		var game3 = new PacMan();
		var gameRunner = new GameRunner(game2); // pass whichever game you want to run as GameRunner is loosely coupled
		// in Line14 :- 2.ObjectCreation of gameRunner + wiring of dependencies ; wiring : Injecting of dependency.
		// game(1/2/3) is dependency of GameRunner 
		gameRunner.run();
	} 
}

/*
 * Why var is working in java 
 * it is java core feature from java10+ 
 * 'var' in java is local variable type reference just like 'auto' in cpp

	var marioGame = new MarioGame();

At compile time, Java rewrites this as:

	MarioGame marioGame = new MarioGame();

 */

