package reporting;

import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.reporters.NullStoryReporter;

import com.aventstack.extentreports.ExtentTest;

public class ExtentStoryReporter extends NullStoryReporter{
	
	ExtentReport extent = ExtentReport.getExtentReport();
	ExtentTest scenar;
	ThreadLocal<Story> storyThread = new ThreadLocal<Story>();
	ThreadLocal<Scenario> scenarioThread = new ThreadLocal<Scenario>();
	
	
	@Override
	public void beforeStory(Story story, boolean givenStory) {
		storyThread.set(story);
		if(!(storyThread.get().getName().contains("BeforeStories")) && !(storyThread.get().getName().contains("AfterStories"))) {
			extent.startReport(storyThread.get().getName().substring(0, storyThread.get().getName().lastIndexOf(".")));
			System.out.println(storyThread.get().getName() +" Story Started");
		}
	}

	@Override
	public void beforeScenario(Scenario scenario) {
		if(null!=storyThread.get() && scenarioThread.get()==null)
			scenarioThread.set(scenario);
		scenar = extent.createTest(scenarioThread.get().getTitle());
		System.out.println(scenarioThread.get().getTitle() +" Scenario Started");
	}
	
	@Override
	public void beforeStep(String step) {
		extent.createNode(step,scenar);
	}	

	@Override
	public void afterScenario() {
		System.out.println(scenarioThread.get().getTitle() +" Scenario Ended");
		scenarioThread.set(null);
	}
	
	@Override
	public void afterStory(boolean givenOrRestartingStory) {
		System.out.println(storyThread.get().getName() +" Story Completed");
		if(!(storyThread.get().getName().contains("BeforeStories")) && !(storyThread.get().getName().contains("AfterStories")))
			extent.generateReports();
			storyThread.set(null);
	}
	
	@Override
	public void successful(String step) {
		System.out.println(step+" [PASSED]");
		
	}
	
	@Override
	public void pending(String step) {
		System.out.println(step+" [PENDING]");
		
	}
	
	@Override
	public void notPerformed(String step) {
		System.out.println(step+" [NOT PERFORMED]");
		
	}
	
	@Override
	public void failed(String step, Throwable cause) {
		System.out.println(step+" [FAILED]");
		
	}
}
