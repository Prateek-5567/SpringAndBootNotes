package com.Prateek.learn_spring_framework;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import com.Prateek.learn_spring_framework.game.GameRunner;
import com.Prateek.learn_spring_framework.game.GamingConsole;
import com.Prateek.learn_spring_framework.game.PacMan;


@Configuration
public class GamingConfiguration {
	@Bean
	public GamingConsole game() {
		var game = new PacMan();
		return game;
	}
	
	@Bean(name = "gameRunner")
	public GameRunner gameRunner(GamingConsole game) {
		var gameRun = new GameRunner(game);
		return gameRun;
	}
}
// see : PacMan game implements gaming console so an object of PacMan game is somehow also an instance of GamingConsole.