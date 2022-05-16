package testpackages;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class Tests_GET {
	
	@Test
	public void test_01() {
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			log().all();		
	}
	
	
	@Test
	public void test_02() {
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.id[0]", equalTo(7)).
			body("data.first_name", hasItems("Michael1","Lindsay", "Tobias"));
	}

}
