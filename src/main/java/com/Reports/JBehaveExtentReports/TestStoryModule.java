package com.Reports.JBehaveExtentReports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestStoryModule {
	
	private static Logger log = LoggerFactory.getLogger(TestStoryModule.class);
	
	public void methodInStoryModule() {
		
		TestPageObject testPO = new TestPageObject();
		String textFromPO = testPO.methodInPageObject();
		LogAndReport.info("Assertion Started", log);
		LogAndReport.error("Assertion Failed", log);
		AssertAndReport.assertEquals("Auth Response code value mismatch", "Failed", textFromPO);
	}

}
