package automationAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	
	@Test
	void registrationSucessful() {
		
		//Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request pay load sending along with post request
		JSONObject reqPrams = new JSONObject();
		reqPrams.put("FirstName", "ABC");
		reqPrams.put("LastName", "XYX");
		reqPrams.put("UserName", "abcxyz");
		reqPrams.put("Password", "23456");
		reqPrams.put("email", "abc@gamil.com");
		
		httpRequest.header("Content-Type", "application/jason");
		httpRequest.body(reqPrams.toJSONString());   //Attach data to the request
		
		//Response Object
		Response response = httpRequest.request(Method.POST,"/register");
		
		//Print response in the console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String succesCode = response.jsonPath().get("SuccesCode");
		Assert.assertEquals(succesCode, "OPERATION_SUCCESS");
		
		//Status line Validation
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 OK");
	}

}
