package stepDefination1;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Latest_FXR_base1 {
Response res;
//assigning host to baseuri
@Given("rates API for latest foreign Exchange rates with base")
public void rates_API_for_latest_foreign_Exchange_rates_with_base() throws Exception{
    
    RestAssured.baseURI="https://api.ratesapi.io";
}

@When("The API with base is Available")
public void the_API_with_base_is_Available() throws Exception {
	 // getting url
    res=RestAssured.get("/api/latest?base=USD");
}

@Then("verify the response status code of base API is {int}")
public void verify_the_response_status_code_of_base_API_is(Integer int1)  throws Exception{
	
	 //To check the status code
	System.out.println("status code"+res.getStatusCode());
	Assert.assertEquals(200, res.getStatusCode());
}
//Used to check the stastus line
@Then("symbol API response status line is HTTP\\/{double} {int}  OK")
public void symbol_API_response_status_line_is_HTTP_OK(Double double1, Integer int1) throws Exception{
   
	 String http1=res.getStatusLine();
	 System.out.println("StatusLine: "+http1);
	 http1.equals("HTTP/1.1 200 OK");
	 
}

}
