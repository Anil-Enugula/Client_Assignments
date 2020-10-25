package stepDefination5;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Specified_date_with_symbol_response {
    Response res;
	@Given("rates API for  Specific date foreign Exchange rates with symbol")
	public void rates_API_for_Specific_date_foreign_Exchange_rates_with_symbol() {
	    RestAssured.baseURI="https://api.ratesapi.io";
	}
    @When("The API with symbols is Available")
	public void the_API_with_symbols_is_Available() {
	   res=RestAssured.get("/api/2010-01-12?symbols=USD,GBP");
	   }
    @Then("verify the response of the api")
	public void verify_the_response_of_the_api() {
		JsonPath js=res.jsonPath();
		String base=js.get("base");
		System.out.println("Base  is:"+base);
		Assert.assertEquals("EUR", base);
		//Asserting Sumbol with Query Parameters
		JsonPath jp2=res.jsonPath();
		 HashMap<String, Double> val2=jp2.get("rates");
		 Set<Entry<String,Double>> rate=val2.entrySet();
			for(Map.Entry<String, Double> val:rate)
			{
				System.out.println(val.getKey()+"  :"+val.getValue());
				if(val.getKey()=="USD" || val.getKey()=="GBP") {
				System.out.println("Passed");}
				}
	    }
@Then("verify the date")
	public void verify_the_date() {
		JsonPath js1=res.jsonPath();
		String date=js1.get("date");
		System.out.println("Date is:"+date);
		Assert.assertEquals("2010-01-12", date);
	    	}
}
