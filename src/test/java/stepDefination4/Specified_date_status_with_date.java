package stepDefination4;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Specified_date_status_with_date {
	
	Response res;
	
	@Given("Rates API for the Specific date Foreign Exchange rates")
	public void rates_API_for_the_Specific_date_Foreign_Exchange_rates() {
	  RestAssured.baseURI="https://api.ratesapi.io"; 
	}

	@When("The API is Available")
	public void the_API_is_Available() {
		//Providing URL

		res=RestAssured.get("/api/2010-01-12");
		
	}

	@Then("verify the status code of response success")
	public void verify_the_status_code_of_response_success() {
		//Asserting Status
		int status=res.getStatusCode();
		System.out.println("Status code:"+status);
		Assert.assertEquals(200, status);

		
		
	}

}
