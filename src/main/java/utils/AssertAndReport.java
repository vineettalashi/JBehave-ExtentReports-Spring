package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reporting.ExtentReport;

public class AssertAndReport {
	
	private static ExtentReport extent = ExtentReport.getExtentReport();
	private static ExtentTest test;
	public static void assertEquals(String message,String expected,String actual) {
		test = extent.getCurrentExtentTest();
		if(expected.equals(actual)) {
			test.log(Status.PASS, "Assert Pass");
		}
		else {
			test.log(Status.FAIL, message+". Expected Value: "+expected+". Actual value: "+actual);
		}
	}

}
