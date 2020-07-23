package com.Reports.JBehaveExtentReports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages= {"com.Reports.JBehaveExtentReports"})
public class SpringConfiguration {
	

	@Bean
	public ExtentReport getExtentReport() {
		ExtentReport report = ExtentReport.getExtentReport();
		return report;
	}
}
