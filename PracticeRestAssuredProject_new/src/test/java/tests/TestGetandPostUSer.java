package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestGetandPostUSer {

	@Test
	public void TestGetandPostMethod() {

		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200);

	}

	@Test
	public void TestPostUSer() {
		Map<String, Object> map = new HashMap<String, Object>();

		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");

		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
		body(request.toJSONString()).when().
		post("/users").
		then().statusCode(201).log().all();
		

	}
	

}
