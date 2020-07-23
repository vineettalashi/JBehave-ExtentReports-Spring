package runner;

import org.jbehave.core.junit.JUnitStories;
import org.springframework.context.ApplicationContext;

public abstract class CustomJunitRunner extends JUnitStories{
	
	public ApplicationContext appContext;

	public abstract ApplicationContext getAnnotatedAppliocationContext();
}
