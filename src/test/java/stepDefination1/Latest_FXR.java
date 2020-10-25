package stepDefination1;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Latest_FXR {
	Response res;

//assigning host to baseuri
@Given("Rates API for the Latest Foreign Exchange rates")
public void rates_API_for_the_Latest_Foreign_Exchange_rates() throws Exception {
   
	RestAssured.baseURI="https://api.ratesapi.io";
    
}


@When("The API is Available")
public void the_API_is_Available() throws Exception {
    // getting url
	res=RestAssured.get("/api/latest");
   
}

@Then("verify the status code of response success")
public void verify_the_status_code_of_response_success()  throws Exception{
    //To check the status code
	System.out.println("status code of response"+res.getStatusCode());
	Assert.assertEquals(200, res.getStatusCode());
    
}
}
