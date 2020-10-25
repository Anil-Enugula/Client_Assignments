Feature: Assert the future date provided at specified date in Foreign  Exchange rates api
     
    @tag1
	  Scenario: Assert the Response of  Specific date foreign exchange rate api with future date
    Given Rates API with future date for the Specific date Foreign Exchange rates
    When The API is Available
    Then Assert the  response with current date
    
   