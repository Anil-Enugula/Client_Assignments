package stepDefination3;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Latest_FXR_Incorrect {
	
	Response res;
	
	@Given("Incorrect API of Latest Foreign Exchange")
	public void incorrect_API_of_Latest_Foreign_Exchange() {
	  
		RestAssured.baseURI="https://api.ratesapi.io";
		
	}

	@When("The API with incorrect values")
	public void the_API_with_incorrect_values() {
		//Incorrect Symbol is given
		res=RestAssured.get("/api/latest?symbols=EURO");
	}

	@Then("Assert the  response")
	public void assert_the_response() {
	  
		JsonPath js=res.jsonPath();
		String error=js.get("error");
		Boolean output=error.contains("invalid");
		System.out.println("Boolean value:"+output);
		Assert.assertEquals(true, output);
		
		//Assert the Status
		int status=res.getStatusCode();
		System.out.println(status);
		Assert.assertEquals(400, status);
	}

}
