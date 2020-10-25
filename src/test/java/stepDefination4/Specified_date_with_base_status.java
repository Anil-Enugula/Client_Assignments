package stepDefination4;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Specified_date_with_base_status {

	Response res;
	@Given("rates API for Specific date foreign Exchange rates with base")
	public void rates_API_for_Specific_date_foreign_Exchange_rates_with_base() {
	   RestAssured.baseURI="https://api.ratesapi.io"; 
	}
    //URL with base is given
	@When("The API with base is Available")
	public void the_API_with_base_is_Available() {
	  res=RestAssured.get("/api/2010-01-12?base=USD");
	}

	@Then("verify the response status code of base API is {int}")
	public void verify_the_response_status_code_of_base_API_is(Integer int1) {
	    //Getting status code and assert
		int status2=res.getStatusCode();
		System.out.println("Status code:"+status2);
		Assert.assertEquals(200, status2);
	}

	@Then("symbol API response status line is HTTP\\/{double} {int}  OK")
	public void symbol_API_response_status_line_is_HTTP_OK(Double double1, Integer int1) {
		//Getting Status line and assert
		String http2=res.getStatusLine();
		   System.out.println("Httpcode"+http2);
		   Boolean bl=http2.contains("1.1");
		   Assert.assertEquals(true, bl);
	}
}
