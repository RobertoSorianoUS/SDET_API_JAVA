package com.unosquare;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class FirstAPIPostEnhancement {

	@Test
	public void createPost() {

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "JohnAPI Test");
		requestParams.put("job", "QA");

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post("/api/users");

		String body = response.getBody().asPrettyString();
		int StatusCode = response.getStatusCode();
		System.out.println(StatusCode);
		Reporter.log(body);
	}

	@Test
	public void createPostJsonFileRegister() throws IOException, ParseException {

		JSONParser json = new JSONParser();
		FileReader reader = new FileReader("..\\JavaAPI\\src\\test\\java\\json\\Register.json");
		Object obj = json.parse(reader);

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given().log().uri();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(obj.toString());
		Response response = httpRequest.post("/api/register");
		Reporter.log("-- Test Post Register-Successful --");
		Reporter.log("Body sent: "+obj.toString());
		
		//Get response code
		int StatusCode = response.getStatusCode();
		Reporter.log("Status code: "+String.valueOf(StatusCode));
		
		//Get response body
		String body = response.getBody().asString();
		Reporter.log("Body response: "+body);
		
	}
	
	@Test
	public void createPostJsonFileLogin() throws IOException, ParseException {
		
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader("..\\JavaAPI\\src\\test\\java\\json\\Register.json");
		Object obj = json.parse(reader);

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given().log().uri();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(obj.toString());
		Response response = httpRequest.post("/api/login");
		Reporter.log("-- Test Post Login-Successful --");
		Reporter.log("Body sent: "+obj.toString());
		
		//Get response code
		int StatusCode = response.getStatusCode();
		Reporter.log("Status code: "+String.valueOf(StatusCode));
		
		//Get response body
		String body = response.getBody().asString();
		Reporter.log("Body response: "+body);
		
	}

}
