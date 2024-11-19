package com.example.games_service;

import org.springframework.boot.SpringApplication;

public class TestGamesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(GamesServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
