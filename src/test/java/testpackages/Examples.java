package testpackages;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {

	@Test(priority = 1)
	public void test_get() {
		
		baseURI ="http://localhost:3000";
		
		given().
			param("firstName", "Shahnawaz").
			get("/user").
		then().
			statusCode(200).
			log().all();	
	}
	
	@Test(priority = 2)
	public void test_post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Gufran1");
		request.put("lastName", "Ali2");
		request.put("SubjectId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/user").		
		then().
			statusCode(201).
			log().all();
	}
	
	//@Test(priority = 3)
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Mustakim");
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/user/2").		
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test(priority = 4)
	public void test_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Tolly1");
		request.put("lastName", "Kamran1");
		request.put("subjectId", 2);
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/user/2").		
		then().
			statusCode(200).
			log().all();
	}
	
	
	//@Test(priority = 5)
	public void test_delete() {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/user/2").
		then().
			statusCode(200);
	}
	
}
