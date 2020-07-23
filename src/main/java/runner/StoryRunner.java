package runner;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import configuration.SpringConfiguration;
import reporting.ExtentStoryReporter;

@RunWith(SpringJUnit4ClassRunner.class)
public class StoryRunner extends CustomJunitRunner   {

	@Override
	protected List<String> storyPaths() {
		List<String> storiesList = new ArrayList<String>();
		StoryFinder sf = new StoryFinder();
		URL baseLocation = CodeLocations.codeLocationFromClass(this.getClass());
		String storiesToRun = System.getProperty("StoryName","*");
		System.out.println("storiesToRun"+storiesToRun);
		String[] storyNamesArray = storiesToRun.split("'");
		for(String storyName : storyNamesArray) {
			String lookUpPath = String.format("**/stories/*%s.story", storyName);
			storiesList.addAll(sf.findPaths(baseLocation, lookUpPath, ""));
		}
		System.out.println("Stories Being Executed"+storiesList);
		return storiesList;
	}

	@Override
	public ApplicationContext getAnnotatedAppliocationContext() {
		return new AnnotationConfigApplicationContext(SpringConfiguration.class);
	}
	
	@Override
    public Configuration configuration() {
		Format[] formats = new Format[] { Format.CONSOLE,Format.HTML,Format.JSON};
			return new MostUsefulConfiguration()
		    .useStoryControls(new StoryControls()
		    .doResetStateBeforeScenario(true)
		    .doSkipScenariosAfterFailure(false))
		    .useStoryLoader(new LoadFromClasspath(this.getClass()))
		    .useStoryReporterBuilder(new StoryReporterBuilder().withReporters(new ExtentStoryReporter()).withDefaultFormats().withFormats(formats));
	}
	
	 @Override
	    public InjectableStepsFactory stepsFactory() {
	        return new SpringStepsFactory(configuration(), getAnnotatedAppliocationContext());
	    }

}
