package automationAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void getValidationHeaders() {
		
		//Specify URI
		RestAssured.baseURI = "https://www.google.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
	
		//Response Object
		Response response = httpRequest.request(Method.GET, "/maps/place/Jama+Masjid+Moradabad/@28.8433276,78.729295,13z/data=!4m9!1m2!2m1!1sjama+masjid+moradabad!3m5!1s0x390afb3a847d665f:0xac63808f3f1f1f6f!8m2!3d28.8334004!4d78.7917998!15sChVqYW1hIG1hc2ppZCBtb3JhZGFiYWSSAQZtb3NxdWU");
		
		//Print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		//Capture the details from response headers
		String contentType = response.header("Content-Type");   //Capture details from header
		System.out.println("Content-Type is: "+ contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
		
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");
		
		
		
	}

}
