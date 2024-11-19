package com.example.games_service;

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
class GamesServiceApplicationTests {

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
	void shouldSubmitGame() {
		String submitGameJson = """
				{
				  "title": "title1",
				  "description_game":"2",
				  "developer":"73",
				  "publisher":"73",
				  "release_date":"2005-10-10",
				  "price":1298,
				  "rating":4
				}
				""";
		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(submitGameJson)
				.when()
				.post("/api/catalog")
				.then()
				.log().all()
				.statusCode(201)
				.extract()
				.body().asString();
		assertThat(responseBodyString, Matchers.is("Game Placed Successfully"));


	}
}
