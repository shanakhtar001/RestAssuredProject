package testpackages;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	
	@Test
	public void test_01() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asString());
		System.out.println("StatusCode : "+response.statusCode());
		System.out.println("Body : "+response.body().asString());
		System.out.println("Status Line : "+response.getStatusLine());
		System.out.println("Header : "+response.getHeader("content-type"));
		System.out.println("Response Time : "+response.getTime());
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	void test_02() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
		
		
	}
	

}
