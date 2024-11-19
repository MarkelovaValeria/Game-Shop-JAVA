package com.example.shoppingCart_service;

import org.springframework.boot.SpringApplication;

public class TestShoppingCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ShoppingCartServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
