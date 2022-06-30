package automationAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTestCases_AddNewEmployees {
	
	@Test
	void addNewEmployees() {
		
		//Specify Base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject reqPhrams = new JSONObject();
		reqPhrams.put("name", "abcd");
		reqPhrams.put("salary", "2345");
		reqPhrams.put("age", "30");
		
		//Response Object
		Response response = httpRequest.request(Method.POST, "/api/v1/create");
		
		//Print response body in the console
		String responseBody = response.getBody().asString();
		
		
	}

}
