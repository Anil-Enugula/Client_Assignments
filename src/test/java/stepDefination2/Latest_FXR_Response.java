package stepDefination2;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Latest_FXR_Response {
Response res;
	@Given("Rates API for the Latest Foreign Exchange rates")
public void rates_API_for_the_Latest_Foreign_Exchange_rates() throws Exception {
    RestAssured.baseURI="https://api.ratesapi.io";
}
@When("The API is Available")
public void the_API_is_Available() throws Exception{
   
	RestAssured.basePath="/api/latest";
}
@Then("Assert the  response")
public void assert_the_response() throws Exception {
   // Asserting response
	res=given().contentType(ContentType.JSON).log().all().get();
	String base1=given().contentType(ContentType.JSON).log().all().get().then().extract().path("base");
	res.prettyPrint();
	System.out.println("value is "+base1);
    HashMap<String, Double> rate1=given().contentType(ContentType.JSON).log().all().get().then().extract().path("rates");
	
	Set<Entry<String,Double>> rate=rate1.entrySet();
		for(Map.Entry<String, Double> val:rate)
		{
			System.out.println(val.getKey()+"  :"+val.getValue());
		}
		String date=given().contentType(ContentType.JSON).log().all().get().then().extract().path("date");
		System.out.println("Date:"+date);
	 System.out.println("Validate");
	 Assert.assertEquals("EUR", base1);
}
}
