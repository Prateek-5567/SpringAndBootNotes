package com.Prateek.learn_spring_framework.game;

public class SuperContra implements GamingConsole{
	public void  up() {
		System.out.println("Jump");
	}
	public void down() {
		System.out.println("Sit Down");
	}
	public void right() {
		System.out.println("Shoot a Bullet");
	}
	public void left() {
		System.out.println("Face Leftward");
	}
}
