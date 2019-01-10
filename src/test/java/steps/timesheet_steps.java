package steps;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import framework.DriverUtil;

public class timesheet_steps {
	
	// get the driver:
	WebDriver browser = DriverUtil.getDriver();
	
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails(DataTable credentialsTable) throws Exception {
	    		
		// get the credentials data from scenario
		List<List<String>> data = credentialsTable.raw();
		
		String timesheetUrl = data.get(1).get(0);
		String username = data.get(1).get(1);
		String password = data.get(1).get(2);
				
		// navigate to timesheet login page
		browser.get(timesheetUrl);
		
		// find the elements
		WebElement inputUsername = browser.findElement(By.id("userid"));
		WebElement inputPassword = browser.findElement(By.id("pwd"));
		WebElement buttonLogin = browser.findElement(By.name("Submit"));
		
		//fill the username
		inputUsername.clear();
		inputUsername.sendKeys(username);
		
		// fill the password
		inputPassword.clear();
		inputPassword.sendKeys(password);
		
		// click on the login button
		buttonLogin.click();
		
		// verify that everything is ok:
		WebElement buttonReports = browser.findElement(By.id("win0groupletPTNUI_LAND_REC_GROUPLET$0"));
		assertTrue(buttonReports.isDisplayed());
		
		//blablabla
	}
}