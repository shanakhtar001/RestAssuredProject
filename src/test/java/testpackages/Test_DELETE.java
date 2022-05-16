package testpackages;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class Test_DELETE {

	@Test
	public void test_1_delete() {
		JSONObject request = new JSONObject();
		request.put("Name", "Shan Akhtar");
		request.put("Job", "Test Engineer");

		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
