package stepDefination2;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class Latest_FXR_With_symbol2_response {
Response res;
@Given("rates API for latest foreign Exchange rates with symbol")
public void rates_API_for_latest_foreign_Exchange_rates_with_symbol() {
	//URL with symbol is given
	 RestAssured.baseURI="https://api.ratesapi.io";
	}
@When("The API with symbol is Available")
public void the_API_with_symbol_is_Available() {
	//URL with symbol
	res=RestAssured.get("/api/latest?symbols=USD");   
}
@Then("verify the response of the api")
public void verify_the_response_of_the_api() {
//Validating the values
  JsonPath jp=res.jsonPath();
  String val1=jp.get("base");
 System.out.println( "Base value:"+ val1);
 
 Assert.assertEquals("EUR", val1);
 
 JsonPath jp2=res.jsonPath();
 HashMap<String, Double> val2=jp2.get("rates");
 Set<Entry<String,Double>> rate=val2.entrySet();
	for(Map.Entry<String, Double> val:rate)
	{
		System.out.println(val.getKey()+"  :"+val.getValue());
		
		Assert.assertEquals("USD", val.getKey());
	}
 
}
}
