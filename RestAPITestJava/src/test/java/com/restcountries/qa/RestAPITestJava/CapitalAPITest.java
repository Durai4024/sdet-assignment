package com.restcountries.qa.RestAPITestJava;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CapitalAPITest {

	@BeforeClass
	public void setup() {

		RestAssured.baseURI = "https://restcountries.com";
		RestAssured.basePath = "v3.1/capital";
	}

	@Test
	public void getCapitalTest() {

		given().when().get("/tallinn").then().statusCode(200).and().body("[0].name.common", equalTo("Estonia")).and()
				.body("[0].name.official", equalTo("Republic of Estonia"));

	}

	@Test
	public void getCapitalWithInvalidDataTest() {

		given().when().get("/New York").then().statusCode(404).and().body("message", equalTo("Not Found"));

	}
}
