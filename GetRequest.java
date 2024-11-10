package selenium;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest{

	public static void main(String[] args) {
		
		RestAssured.useRelaxedHTTPSValidation();
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		//RestAssured.basePath = "service/fms/workflowCompletion";
		given().
		        queryParam( "page", "2")
		        .body("")
		.when().
		        get()
		.then().
		        assertThat().statusCode(200)
		        .body("page", equalTo(2));	
		
	}
	
}
