package testpackages;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests_POST {

	@Test
	public void test_1_post() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Shahnawaz");
		map.put("Job", "Software Engineer");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then(). 	
			statusCode(201);		
	}	
}
