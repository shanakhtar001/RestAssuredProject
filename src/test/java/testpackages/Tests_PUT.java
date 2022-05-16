package testpackages;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class Tests_PUT {
	
	@Test
	void test_2_put() {
		
		JSONObject request = new JSONObject();
		request.put("Name", "Shan");
		request.put("Job", "Engineer");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request).			
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
}
