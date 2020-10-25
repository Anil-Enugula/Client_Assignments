package stepDefination5;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Specified_date_response {

Response res;
@Given("Rates API for the Specific date Foreign Exchange rates")
public void rates_API_for_the_Specific_date_Foreign_Exchange_rates() throws Exception {
   RestAssured.baseURI="https://api.ratesapi.io"; 
}

@When("The API is Available")
public void the_API_is_Available() throws Exception{
	//URL given
    res=RestAssured.get("/api/2010-01-12");
}

@Then("Assert the  response")
public void assert_the_response() throws Exception {
res=given().contentType(ContentType.JSON).log().all().get();
	//Asserting base response
	String base1=given().contentType(ContentType.JSON).log().all().get("/2010-01-12").then().extract().path("base");
	
	res.prettyPrint();
	System.out.println("value is "+base1);
	Assert.assertEquals("EUR", base1);
	
	//Asserting Response with date
	String date=given().contentType(ContentType.JSON).log().all().get("/2010-01-12").then().extract().path("date");
	System.out.println("Date:"+date);
	Assert.assertEquals("2010-01-12", date);
}
}
