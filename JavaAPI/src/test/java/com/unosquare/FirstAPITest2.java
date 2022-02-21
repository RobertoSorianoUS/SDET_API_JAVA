package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class FirstAPITest2 {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/unknown/2");
		
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode,200);
		Reporter.log("Sucess 200 validation");
		Reporter.log(response.body().asString());
		
		response.
		then().
			body("data.id", equalTo(2)).
			body("data.name", equalTo("fuchsia rose")).
			body("data.year", equalTo(2001)).
			body("data.color", equalTo("#C74375")).
			body("data.pantone_value", equalTo("17-2031")).
			body("support.url", equalTo("https://reqres.in/#support-heading")).
			body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
  }

  @Test
  public void f_Gherkin() {
	  
	  given()
	  .when().
	  	get("https://reqres.in/api/unknown/2")
	  .then().
	  	assertThat().statusCode(200).
	  	assertThat().contentType(ContentType.JSON).
	  	assertThat().body("data.id", equalTo(2)).
	  	assertThat().body("data.name", equalTo("fuchsia rose")).
	  	assertThat().body("data.year", equalTo(2001)).
	  	assertThat().body("data.color", equalTo("#C74375")).
	  	assertThat().body("data.pantone_value", equalTo("17-2031")).
	  	assertThat().body("support.url", equalTo("https://reqres.in/#support-heading")).
	  	assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	  
	  Reporter.log("Sucess 200 validation");
}
  
  @BeforeMethod
  public void beforeMethod() {
  }

}
