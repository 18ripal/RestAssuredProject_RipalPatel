package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestLocalAPI {

	@Test(priority = 1)
	public void GetRequest() {

		baseURI = "http://localhost:3000";
		given().get("Users").then().statusCode(200).log().all();

	}

	@Test(priority = 2)
	public void PostRequest() {

		JSONObject object = new JSONObject();

		object.put("FirstName", "henry");
		object.put("LastName", "doc");
		object.put("SubjectId", 2);

		baseURI = "http://localhost:3000";
		given().body(object.toJSONString()).when().post("/Users")
				.then().statusCode(201);

	}

	@Test(priority = 3)
	public void PutRequest() {

		JSONObject object = new JSONObject();

		object.put("FirstName", "Robot");
		object.put("LastName", "Brook");
		object.put("SubjectId", 3);

		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(object.toJSONString()).when()
				.put("/Users/1").then().statusCode(200);

	}

	@Test(priority = 4)
	public void PatchRequest() {

		JSONObject object = new JSONObject();

		object.put("LastName", "mac");

		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(object.toJSONString()).when()
				.patch("/Users/1").then().statusCode(200);

	}

	@Test(priority = 5)
	public void DeleteRequest() {

		baseURI = "http://localhost:3000";
		when().delete().then().statusCode(204);
	}

}
