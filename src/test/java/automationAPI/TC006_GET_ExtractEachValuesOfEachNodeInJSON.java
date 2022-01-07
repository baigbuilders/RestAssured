package automationAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_ExtractEachValuesOfEachNodeInJSON {
	
	
	@Test
	public void getEachNode() {
		
		
		//Specify the URI
		RestAssured.baseURI = "";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"");
		
		//Print response in the console window
	
	}

}
