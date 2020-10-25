package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features/AcceptanceCriteria6.feature",
		glue= {"stepDefination6"},
		tags= {"@tag1"}
		
	
		
	)
public class testRunner {

}
