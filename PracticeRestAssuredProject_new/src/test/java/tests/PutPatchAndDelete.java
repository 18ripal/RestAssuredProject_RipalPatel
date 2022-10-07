package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchAndDelete {
	
	@Test(priority = 1)
	public void TestPutUser() {

	JSONObject request = new JSONObject();
	request.put("name", "morpheus");
	request.put("job", "leader");

	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	given().put("/users/2").then().statusCode(200).log().all();
	

}
	@Test(priority = 2)
		public void TestPatchUser() {

		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");

		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().patch("/users/2").then().statusCode(200).log().all();
		

	}
		
		@Test(priority = 3)
		public void TestDeleteUser() {

		
		baseURI = "https://reqres.in/api";
		given().delete("/users/2").then().statusCode(204).log().all();
		

	}
		
		
		
		

}
