
Feature: Test the  success status of Specific date Foreign  Exchange rates api
     
    @tag1
	  Scenario: Assert the success status of Specific date foreign exchange rate api response
    Given Rates API for the Specific date Foreign Exchange rates
    When The API is Available
    Then verify the status code of response success
   
   @tag2
    Scenario: Assert the success status of response of Specific date foreign Exhange with symbol
    Given rates API for Specific date foreign Exchange rates with symbol
    When The API with symbol is Available
    Then verify the response status code of symbol API is 200
    And symbol API response HTTP version is 1.1
   
   @tag3
   Scenario: Assert the success status of response of Specific date foreign Exhange with base
   Given rates API for Specific date foreign Exchange rates with base
   When The API with base is Available
   Then verify the response status code of base API is 200
   And symbol API response status line is HTTP/1.1 200  OK
   
   @tag4
   Scenario: Assert the success status of response of Specific date foreign Exhange with symbol and base 
   Given rates API for Specific date foreign Exchange rates with symbol and base 
   When The API with symbol and base is Available
   Then verify the response status code of symbol and  base API is 200
 