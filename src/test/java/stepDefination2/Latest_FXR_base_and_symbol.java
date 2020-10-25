package stepDefination2;

import java.time.LocalDate;
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

public class Latest_FXR_base_and_symbol {
Response res;
@Given("rates API for latest foreign Exchange rates with symbol and base")
public void rates_API_for_latest_foreign_Exchange_rates_with_and_base() throws Exception {
   
	RestAssured.baseURI="https://api.ratesapi.io";
	}
@When("The API with symbol and base is Available")
public void the_API_with_symbol_and_base_is_Available() throws Exception {
    
	res=RestAssured.get("/api/latest?base=USD&symbols=GBP");
}
@Then("verify  response of API")
public void verify_response_of_API() throws Exception{
	//Asserting the date and base
	JsonPath jp=res.jsonPath();
	  String val1=jp.get("base");
	 System.out.println("Base Value:"+val1);
	 Assert.assertEquals("USD", val1);
	 JsonPath jp2=res.jsonPath();
	 HashMap<String, Double> val2=jp2.get("rates");
	 Set<Entry<String,Double>> rate=val2.entrySet();
		for(Map.Entry<String, Double> val:rate)
		{
			System.out.println(val.getKey()+"  :"+val.getValue());
			
			Assert.assertEquals("GBP", val.getKey());
		}
		String date=res.jsonPath().get("date");
		System.out.println("Date in uri :"+date);
		LocalDate currentdate=LocalDate.now();
		Assert.assertEquals(currentdate, date);
}
}
