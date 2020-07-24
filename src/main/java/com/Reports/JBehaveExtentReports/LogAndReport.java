package com.Reports.JBehaveExtentReports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LogAndReport {
	
	private static ExtentReport extent = ExtentReport.getExtentReport();
	private static ExtentTest test;
	private static Logger log;
	
	public static <T> Logger getLogger(Class<T> clazz) {
		log = LoggerFactory.getLogger(clazz);
		return log;
	}
	
	public static void info(String message,Logger log) {
		test = extent.getCurrentExtentTest();
		log.info(message);
		extent.setCurrentExtentTest(test.log(Status.INFO, message));		
	}
	
	public static void error(String message,Logger log) {
		test = extent.getCurrentExtentTest();
		log.error(message);
		extent.setCurrentExtentTest(test.log(Status.ERROR, message));		
	}

}
