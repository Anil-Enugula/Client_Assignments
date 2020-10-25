package stepDefination5;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Specified_date_with_Base_Response {

Response res;
@Given("rates API for Specific date foreign Exchange rates with base")
public void rates_API_for_Specific_date_foreign_Exchange_rates_with_base() throws Exception{
 
	RestAssured.baseURI="https://api.ratesapi.io";
}

@When("The API with base is Available with date")
public void the_API_with_base_is_Available_with_date() throws Exception {
	
	res=RestAssured.get("/api/2010-01-12?base=USD");
 
}
@Then("verify the response of API")
public void verify_the_response_of_API() throws Exception{
  //Asserting Base 
	JsonPath js1=res.jsonPath();
	String base1=js1.get("base");
	System.out.println("Base value::"+base1);
	Assert.assertEquals("USD", base1);
}

@Then("Assert the date")
public void assert_the_date() throws Exception{
	//Assertin date Response 
	JsonPath js2=res.jsonPath();
	String date=js2.get("date");
	System.out.println("The date::"+date);
	Assert.assertEquals("2010-01-12", date);  
}
}
