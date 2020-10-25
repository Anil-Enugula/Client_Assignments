package stepDefination1;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Latest_FXR_Base_and_Symbol {
	Response res;

	//assigning host to baseuri
	@Given("rates API for latest foreign Exchange rates with symbol and base")
	public void rates_API_for_latest_foreign_Exchange_rates_with_symbol_and_base() throws Exception{
	   
		RestAssured.baseURI="https://api.ratesapi.io";
	  
	}

	@When("The API with symbol and base is Available")
	public void the_API_with_symbol_and_base_is_Available() throws Exception {
		 // getting url
	   res=RestAssured.get("/api/latest?base=USD&symbols=GBP");
	    
	}

	@Then("verify the response status code of symbol and  base API is {int}")
	public void verify_the_response_status_code_of_symbol_and_base_API_is(Integer int1) throws Exception {
	    //Asserting the statuscode
		System.out.println("status code "+res.getStatusCode());
		Assert.assertEquals(200, res.getStatusCode());
	}
}
