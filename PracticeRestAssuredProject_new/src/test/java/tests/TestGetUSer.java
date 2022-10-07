package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestGetUSer{
	
	
	@Test
	public void CreateUserTest() {
		
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());
		System.out.println(response.getHeader("Content-Type"));
		
		
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void CreateUserTestupdate() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
	}

}
