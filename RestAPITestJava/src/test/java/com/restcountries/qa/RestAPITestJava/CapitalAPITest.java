package com.restcountries.qa.RestAPITestJava;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CapitalAPITest {
	
  @Test
  public void getCapitalAPITest() {
	  RestAssured.baseURI = "https://restcountries.com";
	  RestAssured.basePath = "v3.1/capital";
	  
	  given().when().get("/tallinn")
	  .then().statusCode(200);
	  
	  Response res = given().when().get("/tallinn");
	  
	  System.out.println(res.asPrettyString());
	  
	  
	  
  }
}
