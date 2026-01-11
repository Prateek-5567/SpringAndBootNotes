package com.Prateek.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component("contra") 
public class SuperContra implements GamingConsole{
	public void  up() {
		System.out.println("contra Jump");
	}
	public void down() {
		System.out.println("contra Sit Down");
	}
	public void right() {
		System.out.println("contra Shoot a Bullet");
	}
	public void left() {
		System.out.println("contra Face Leftward");
	}
}
