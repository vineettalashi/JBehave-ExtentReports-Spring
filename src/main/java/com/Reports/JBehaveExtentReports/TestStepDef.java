package com.Reports.JBehaveExtentReports;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestStepDef {
	@Autowired
	TestStoryModule testSM;
	
	@Given("Test Given Step")
	public void givenMethodInStepDefinition() {
		testSM.methodInStoryModule();
	}
	
	@When("Test When Step")
	public void whenMethodInStepDefinition() {
		testSM.methodInStoryModule();
	}
	
	@Then("Test Then Step")
	public void thenMethodInStepDefinition() {
		testSM.methodInStoryModule();
	}
	

}
