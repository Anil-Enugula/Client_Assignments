package stepDefination1;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class latest_FXR_symbol1 {
	Response res;
	//assigning host to baseuri
	@Given("rates API for latest foreign Exchange rates with symbol")
	public void rates_API_for_latest_foreign_Exchange_rates_with_symbol()  throws Exception{
	    
	    RestAssured.baseURI="https://api.ratesapi.io";
	}
   @When("The API with symbol is Available")
	public void the_API_with_symbol_is_Available() throws Exception {
		 // getting url
	   res=RestAssured.get("api/latest?symbols=USD,GBP");
	}
    @Then("verify the response status code of symbol API is {int}")
	public void verify_the_response_status_code_of_symbol_API_is(Integer int1) throws Exception {
	   //To check the status code
		System.out.println("status code "+res.getStatusCode());
		Assert.assertEquals(200, res.getStatusCode());
	}

	//Used to check the http version
	@Then("symbol API response HTTP version is {double}")
	public void symbol_API_response_HTTP_version_is(Double double1) throws Exception {
	   
	 String http1=res.getStatusLine();
	 if(http1.contains("1.1"))
	 {
		 System.out.println("http is matched");
	 }
	 else
	 {
		 System.out.println("not matched");
	 }
	 
	}}
