package steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.DriverUtil;
import framework.Wrappers;

public class hook_steps {
	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		System.out.println("Starting execution of the scenario: " + scenario.getName());
		
		WebDriver browser = DriverUtil.initDriver();
		browser.manage().window().maximize();
		
		// timeouts
		browser.manage().timeouts().implicitlyWait(Wrappers.IMPLICIT_WAIT, TimeUnit.SECONDS);
		browser.manage().timeouts().pageLoadTimeout(Wrappers.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		browser.manage().timeouts().setScriptTimeout(Wrappers.JS_WAIT, TimeUnit.SECONDS);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		System.out.println("Execution finished for the scenario: " + scenario.getName());
		
		WebDriver browser = DriverUtil.getDriver();
//		browser.close();
	}
	
}