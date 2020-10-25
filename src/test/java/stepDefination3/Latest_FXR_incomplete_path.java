package stepDefination3;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Latest_FXR_incomplete_path {

	Response res;
	
	@Given("In complete API of Latest Foreign Exchange")
	public void in_complete_API_of_Latest_Foreign_Exchange() throws Throwable{
	   //Incomplete url
		RestAssured.baseURI="https://api.ratesapi.api";
	}

	@When("The API with Incomplete path")
	public void the_API_with_Incomplete_path() throws Throwable {
	   
		res=RestAssured.get("/api/latest");
	}

	@Then("verify the response of the API of Incomplete")
	public void verify_the_response_of_the_API_of_Incomplete() throws Throwable {
		System.out.println("status"+res.getStatusCode());
		System.out.println("http code"+res.getStatusLine());
		
		Boolean bl=res.getBody().toString().contains("error");
		System.out.println("boolean value:" +bl);
		//Asserting Status
		Assert.assertEquals(true, bl);
		Assert.assertEquals(400, res.getStatusCode());
		
		
		
	}

	
	
}
