import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Get {
	@Test
	void test_1() {
		
//		Response response = RestAssured.get("https://reqres.in/api/users?page=2");// for non static import
//		//Response response = get("https://reqres.in/api/users?page=2");// for static omport
//		System.out.println(response.getBody().asString());
//		System.out.println(response.getStatusCode());
//    	//System.out.println(response.asPrettyString());
//		System.out.println(response.contentType());
//		System.out.println(response.getStatusLine());
//		System.out.println(response.getTime());
////		System.out.println(response.getHeader("Content-type"));
//		System.out.println(response.asString());
////		System.out.println();
//		 int statuscode= response.getStatusCode();
//		 Assert.assertEquals(statuscode, 200);				
	}
	@Test
	public void test_2() {
		given()    // static io rstassured import is used for these methods
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7))  // hamcrest matches import
		.body("total_pages", equalTo(2)) // use jason path finder to pind path of jsons
		.body("data.first_name[1]",equalTo( "Lindsay"));
		
	}

}
