package com.Reports.JBehaveExtentReports;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

@Aspect
@Component
public class ExtentReportAspect {
	
	private ExtentReport extent = ExtentReport.getExtentReport();
	private ExtentTest test;
	
	@Around("execution(* com.Reports.JBehaveExtentReports.TestStepDef.*(..))")
    public void reportAroundAllMethodsStepDefinition(ProceedingJoinPoint joinPoint) throws Throwable 
    {
		test = extent.getCurrentExtentTest();
		extent.setCurrentExtentTest(test.log(Status.INFO,"Step definition Method :::"+joinPoint.getSignature().getName() +" Arguements: "+Arrays.toString(joinPoint.getArgs())));
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
    }
	
	@Around("execution(* com.Reports.JBehaveExtentReports.TestStoryModule.*(..))")
    public void reportAroundAllMethodsStoryModule(ProceedingJoinPoint joinPoint) throws Throwable 
    {
		test = extent.getCurrentExtentTest();
		extent.setCurrentExtentTest(test.log(Status.INFO,"Story Module Method :::"+joinPoint.getSignature().getName() +" Arguements: "+Arrays.toString(joinPoint.getArgs())));
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
    }
	
	@Around("execution(* com.Reports.JBehaveExtentReports.AssertAndReport.*(..))")
    public void reportAroundAllMethodsAssert(ProceedingJoinPoint joinPoint) throws Throwable 
    {
		test = extent.getCurrentExtentTest();
		extent.setCurrentExtentTest(test.log(Status.INFO,"Assert and Report :::"+joinPoint.getSignature().getName() +" Arguements: "+Arrays.toString(joinPoint.getArgs())));
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
    }
	
	@Around("execution(* com.Reports.JBehaveExtentReports.LogAndReport.*(..))")
    public void reportAroundAllMethodsLogging(ProceedingJoinPoint joinPoint) throws Throwable 
    {
		test = extent.getCurrentExtentTest();
		extent.setCurrentExtentTest(test.log(Status.INFO,"Log and Report ::: Method ->"+joinPoint.getSignature().getName() +" Arguements: "+Arrays.toString(joinPoint.getArgs())));
        try {
            joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
    }
}
