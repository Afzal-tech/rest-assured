

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_Get_Post {
	
	//@Test
	public void get() {
		baseURI = ("https://reqres.in/api/");
		
		given().get("users?page=2").then().statusCode(200).body("data.first_name",hasItems("Rachel"));
	}
	
	@Test
	public void test_Post() {
		baseURI = ("https://reqres.in/api/");
		
//		Map<String ,Object> map = new HashMap<String ,Object>();
//		map.put("name", "Afzal");
//		map.put("job", "QA");
		
	JSONObject request = new JSONObject();
	request.put("name", "Afzal");
	request.put("job", "QA");
	
	//System.out.println(request.toJSONString());
	given().header("Content-Type", "/application.json/").contentType(ContentType.JSON).accept(ContentType.JSON).
	
	body(request.toJSONString()).
	 when().
	 post("/users").then().statusCode(201).log().all();		
	
				
		
		
		
	}

}
