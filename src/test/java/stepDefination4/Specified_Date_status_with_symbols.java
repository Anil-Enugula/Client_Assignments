package stepDefination4;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Specified_Date_status_with_symbols {

	Response res;
	@Given("rates API for Specific date foreign Exchange rates with symbol")
	public void rates_API_for_Specific_date_foreign_Exchange_rates_with_symbol() throws Exception {
	   
		RestAssured.baseURI="https://api.ratesapi.io";
	}

	@When("The API with symbol is Available")
	public void the_API_with_symbol_is_Available() throws Exception {
	    res=RestAssured.get("/api/2010-01-12?symbols=USD");
	}

	@Then("verify the response status code of symbol API is {int}")
	public void verify_the_response_status_code_of_symbol_API_is(Integer int1) throws Exception {
	    
		int status1=res.getStatusCode();
		System.out.println("Status code:"+status1);
		Assert.assertEquals(200, status1);
	}
	@Then("symbol API response HTTP version is {double}")
	public void symbol_API_response_HTTP_version_is(Double double1) throws Exception {
	   String http1=res.getStatusLine();
	   System.out.println("Httpcode"+http1);
	   Boolean bl=http1.contains("1.1");
	   Assert.assertEquals(true, bl);
	}
}
