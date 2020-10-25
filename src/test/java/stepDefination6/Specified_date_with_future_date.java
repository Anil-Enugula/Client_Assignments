package stepDefination6;

import java.time.LocalDate;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Specified_date_with_future_date {
	
	Response res;
	@Given("Rates API with future date for the Specific date Foreign Exchange rates")
	public void rates_API_with_future_date_for_the_Specific_date_FXR() throws Exception {
	 
		RestAssured.baseURI="https://api.ratesapi.io";
	}

	@When("The API is Available")
	public void the_API_is_Available() throws Exception {
		//Providing Future Date
		res=RestAssured.get("/api/2021-01-12");
	    
	}

	@Then("Assert the  response with current date")
	public void assert_the_response_with_current_date()  throws Exception{
	    //Asserting the url providing Future Date 
		LocalDate current=LocalDate.now();
		//Getting current Date
		System.out.println("Currentdate::"+current);
		//Getting  date in response
		JsonPath js1=res.jsonPath();
		String responsedate=js1.get("date");
		System.out.println("Date in future:"+responsedate);
		Assert.assertEquals(responsedate,current);
	}

}
