
Feature: Assert the response of Specific date Foreign  Exchange rates api
     
    @tag1
	  Scenario: Assert the Response of  Specific date foreign exchange rate api response
    Given Rates API for the Specific date Foreign Exchange rates
    When The API is Available
    Then Assert the  response
   
   @tag2
    Scenario: Assert the response of  Specific date foreign Exhange with symbol
    Given rates API for  Specific date foreign Exchange rates with symbol
    When The API with symbols is Available
    Then verify the response of the api
    And verify the date
   
   
   @tag3
   Scenario: Assert the response of Specific date foreign Exhange with base
   Given rates API for Specific date foreign Exchange rates with base
   When The API with base is Available with date
   Then verify the response of API
   And Assert the date
   
   
   @tag4
   Scenario: Assert the response of  Specific date foreign Exhange with symbol and base 
   Given rates API for  Specific date foreign Exchange rates with symbol and base 
   When The API with symbol and base is Available
   Then verify  response of API
   And Assert the date given
 