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
public class Specified_date_with_symbol_and_base_response {
	Response res;
   @Given("rates API for  Specific date foreign Exchange rates with symbol and base")
	public void rates_API_for_Specific_date_foreign_Exchange_rates_with_symbol_and_base() {
		 RestAssured.baseURI="https://api.ratesapi.io";
	}
    @When("The API with symbol and base is Available")
	public void the_API_with_symbol_and_base_is_Available() {
	   //URL is provide
		res=RestAssured.get("/api/2010-01-12?base=USD&symbols=GBP");
	}
    @Then("verify  response of API")
	public void verify_response_of_API() {
	   //Asserting Base Value
		JsonPath js1=res.jsonPath();
		String base2=js1.get("base");
		System.out.println("Base value::"+base2);
		Assert.assertEquals("USD", base2);
		//Asserting Symbols which are as query parameters
		JsonPath jp2=res.jsonPath();
		 HashMap<String, Double> val2=jp2.get("rates");
		 Set<Entry<String,Double>> rate=val2.entrySet();
			for(Map.Entry<String, Double> val:rate) {
			System.out.println(val.getKey()+"  :"+val.getValue());
				Assert.assertEquals("GBP", val.getKey());
			}
	}
	@Then("Assert the date given")
	public void assert_the_date_given() {
		JsonPath js2=res.jsonPath();
		String date=js2.get("date");
		System.out.println("The date::"+date);
		Assert.assertEquals("2010-01-12", date);
	}
}
