package stepDefination4;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Specified_date_with_symbol_and_base_status {

	Response res;
	@Given("rates API for Specific date foreign Exchange rates with symbol and base")
	public void rates_API_for_Specific_date_foreign_Exchange_rates_with_symbol_and_base() {
	   //Providing URL
		RestAssured.baseURI="https://api.ratesapi.io";
	}

	@When("The API with symbol and base is Available")
	public void the_API_with_symbol_and_base_is_Available() {
	   res=RestAssured.get("/api/2010-01-12?base=USD&symbols=GBP");
	}

	@Then("verify the response status code of symbol and  base API is {int}")
	public void verify_the_response_status_code_of_symbol_and_base_API_is(Integer int1) {
	    //Assert the Status
		System.out.println("status code of response::"+res.getStatusCode());
		Assert.assertEquals(200, res.getStatusCode());
	}
}
