
Feature: Assert the response of latest Foreign  Exchange rates api
     
    @tag1
	  Scenario: Assert the Response of Latest foreign exchange rate api response
    Given Rates API for the Latest Foreign Exchange rates
    When The API is Available
    Then Assert the  response
   
   @tag2
    Scenario: Assert the response of Latest foreign Exhange with symbol
    Given rates API for latest foreign Exchange rates with symbol
    When The API with symbol is Available
    Then verify the response of the api
   
   
   @tag3
   Scenario: Assert the response of Latest foreign Exhange with base
   Given rates API for latest foreign Exchange rates with base
   When The API with base is Available
   Then verify the response of API
   
   
   @tag4
   Scenario: Assert the response of Latest foreign Exhange with symbol and base 
   Given rates API for latest foreign Exchange rates with symbol and base 
   When The API with symbol and base is Available
   Then verify  response of API
 