package stepDefination2;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Latest_FXR_with_Base1 {

	Response res;
	@Given("rates API for latest foreign Exchange rates with base")
	public void rates_API_for_latest_foreign_Exchange_rates_with_base() throws Exception{
	   //URL with base given
		RestAssured.baseURI="https://api.ratesapi.io";
	}

	@When("The API with base is Available")
	public void the_API_with_base_is_Available() throws Exception{
		//Base and value
	   res=RestAssured.get("/api/latest?base=USD");
	}

	@Then("verify the response of API")
	public void verify_the_response_of_API() throws Exception {
	    //Asserting the values
		String date=res.jsonPath().get("date");
		System.out.println("Date is :"+date);
		LocalDate currentdate=LocalDate.now();
		Assert.assertEquals(currentdate, date);
		
		 JsonPath jp=res.jsonPath();
		  String val1=jp.get("base");
		 System.out.println(val1);
		 
		 Assert.assertEquals("USD", val1);
		
	}

}
