package com.Reports.JBehaveExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AssertAndReport {
	
	private static ExtentReport extent = ExtentReport.getExtentReport();
	private static ExtentTest test;
	public static void assertEquals(String message,String expected,String actual) {
		test = extent.getCurrentExtentTest();
		if(expected.equals(actual)) {
			test = test.log(Status.PASS, "Assert Pass");
		}
		else {
			test = test.log(Status.FAIL, message+". Expected Value: "+expected+". Actual value: "+actual);
		}
		extent.setCurrentExtentTest(test);
	}

}
