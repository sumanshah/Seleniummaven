package selenium;

import io.restassured.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateUser {

	public static void main(String[] args) {
	
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		String userData = "{" +
		" \"name\" : \"morpheus\", " +
		" \"job\" : \"zion resident\" " +
		"}";
		
		given().body(userData)
		.when()
		.patch()
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.body("updatedAt", is(notNullValue()));
		
		
	}

}
