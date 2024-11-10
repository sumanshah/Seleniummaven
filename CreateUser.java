package selenium;

import io.restassured.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateUser {

	public static void main(String[] args) {
	
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://reqres.in/api/users";
		String userdata = "{" +
		" \"name\" : \"morpheus\", " + 
		" \"job \" : \"leader\" " +
		"}";
		
		given().body(userdata)
		.when()
		.post()
		.then().log().all()
		.assertThat()
		.statusCode(201)
		.body("id", is(notNullValue()));
		

	}

}
