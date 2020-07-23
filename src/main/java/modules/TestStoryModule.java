package modules;

import org.springframework.stereotype.Component;

import pages.TestPageObject;
import utils.AssertAndReport;

@Component
public class TestStoryModule {
	
	public void methodInStoryModule() {
		
		TestPageObject testPO = new TestPageObject();
		String textFromPO = testPO.methodInPageObject();
		AssertAndReport.assertEquals("Auth Response code value mismatch", "Failed", textFromPO);
	}

}
