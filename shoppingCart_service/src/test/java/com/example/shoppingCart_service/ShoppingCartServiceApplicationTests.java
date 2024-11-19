package com.example.shoppingCart_service;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoppingCartServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
	@LocalServerPort
	private Integer port;
	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	static {
		mySQLContainer.start();
	}

	@Test
	void shouldSubmitOrder() {
		String submitOrderJson = """
				{
					user_id: 1,
					game_id: 3
				}
				""";
		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(submitOrderJson)
				.when()
				.post("/api/shoppingCart")
				.then()
				.log().all()
				.statusCode(201)
				.extract()
				.body().asString();
		assertThat(responseBodyString, Matchers.is("Order Placed Successfully"));
	}

}
