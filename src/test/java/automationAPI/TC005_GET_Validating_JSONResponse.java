package automationAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Validating_JSONResponse {
	
	@Test
	public void getJSONResponse() {
		
		//Specify the URI
		RestAssured.baseURI = "";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET, "/Delhi");
		
		//Print the response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " +responseBody);
		
		Assert.assertEquals(responseBody.contains("Delhi"), true);
	}

}
