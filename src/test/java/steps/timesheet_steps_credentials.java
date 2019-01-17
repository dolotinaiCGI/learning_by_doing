/*
package steps;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import framework.DriverUtil;
import framework.Helpers;

public class timesheet_steps {
	
	// get the driver:
	WebDriver browser = DriverUtil.getDriver();
	
	@Given("^User is logged in the timesheet application$")
	public void user_is_logged_in_the_timesheet_application() throws Exception {
	    		
		// get the url and credentials from the classified.txt file 
		ArrayList<String> classifiedInfo = Helpers.getClassifiedInformation();
		
		String timesheetUrl = classifiedInfo.get(0);
		String username = classifiedInfo.get(1);
		String password = classifiedInfo.get(2);
		
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
		
	}
}
*/