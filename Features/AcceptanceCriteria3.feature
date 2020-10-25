
Feature: Assert the response of latest Foreign  Exchange rates api
     
    @tag1
	  Scenario: Assert the Response of Latest foreign Exchange with Incorrect API
    Given Incorrect API of Latest Foreign Exchange 
    When The API with incorrect values 
    Then Assert the  response
   
   @tag2
    Scenario: Assert the Response of Latest foreign Exchange with Incomplete API
    Given In complete API of Latest Foreign Exchange
    When The API with Incomplete path
    Then verify the response of the API of Incomplete
    
   
   

 