package com.Prateek.learn_spring_framework.game;

public class MarioGame implements GamingConsole{
	public void  up() {
		System.out.println("Mario Jump");
	}
	public void down() {
		System.out.println("Mario Go in Hole");
	}
	public void right() {
		System.out.println("Mario Accelerate rightwards");
	}
	public void left() {
		System.out.println("Mario Accelerate leftwards");
	}
}
