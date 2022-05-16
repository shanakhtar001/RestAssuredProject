package testpackages;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends DataForTests{

		//@Test(dataProvider = "DataForPost")
		public void test_post(String firstName, String lastName, int SubjectId) {
			
			JSONObject request = new JSONObject();
			request.put("firstName", firstName);
			request.put("lastName", lastName);
			request.put("SubjectId", SubjectId);
			
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
				
		
		@Test(dataProvider = "DataForDelete")
		public void test_delete(int userId) {
			
			baseURI = "http://localhost:3000/";
			
			when().
				delete("/user/"+userId).
			then().
				statusCode(200).
				log().all();
		}
}
