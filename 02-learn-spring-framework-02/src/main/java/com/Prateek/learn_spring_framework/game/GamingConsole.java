package com.Prateek.learn_spring_framework.game;

public interface GamingConsole {
	void up();
	void down();
	void left();
	void right();
}

// interface define the default structure that all classes must contain 
// all the classes inherit the structure from it .

// interface helps in looseCoupling .. 

// IMPORTANT : 
// Main point is we can use common Interface for all classes that implements it in GameRunner
// code ; uss class ka run hoga jiska object GameRunner me pass kia h 