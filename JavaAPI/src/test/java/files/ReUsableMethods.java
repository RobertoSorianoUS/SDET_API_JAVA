package files;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReUsableMethods {

	public static Response Api(String path, String resource, int expectStatusCode) throws IOException, ParseException {
		
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = json.parse(reader);

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given().log().uri();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(obj.toString());
		Response response = httpRequest.post(resource);
		Reporter.log("URI: "+RestAssured.baseURI.toString()+resource);
		Reporter.log("Body sent: "+obj.toString());
		
		//Get response code
		int StatusCode = response.getStatusCode();
		Reporter.log("Status code: "+String.valueOf(StatusCode));
		
		//Get response body
		String body = response.getBody().asString();
		Reporter.log("Body response: "+body);
		
		return response;
		
	}
	
	public static Response GetMethod(String resource, int expectStatusCode) {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given().log().uri();
		Response response = httpRequest.get(resource);
		Reporter.log("URI: "+RestAssured.baseURI.toString()+resource);
		
		//Get response code
		int StatusCode = response.getStatusCode();
		Reporter.log("Status code: "+String.valueOf(StatusCode));
		Assert.assertEquals(StatusCode, expectStatusCode);
		
		//Get response body
		String body = response.getBody().asString();
		Reporter.log("Body response: "+body);
		
		return response;
	}
	
public static Response PutMethod(String path, String resource, int expectStatusCode) throws IOException, ParseException {
		
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(path);
		Object obj = json.parse(reader);

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given().log().uri();
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(obj.toString());
		Response response = httpRequest.put(resource);
		Reporter.log("URI: "+RestAssured.baseURI.toString()+resource);
		Reporter.log("Body sent: "+obj.toString());
		
		//Get response code
		int StatusCode = response.getStatusCode();
		Reporter.log("Status code: "+String.valueOf(StatusCode));
		Assert.assertEquals(StatusCode, expectStatusCode);
		
		//Get response body
		String body = response.getBody().asString();
		Reporter.log("Body response: "+body);
		
		return response;
		
	}
}
