package steps;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
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
		
		
	}
	
    @When("^User navigates to CGI Timesheet Reports$")
    public void user_navigates_to_CGI_Timesheet_Reports() {

           //validate login successful
           WebElement img = browser.findElement(By.id("PS_REPORT_TIME_L_FL$0"));
           assertTrue(img.isDisplayed());

           //click on new timesheet
           img.click();
    }
    
    @And("^User fill main time report details$")
    public void user_fill_main_time_report_details(DataTable dataTable) throws InterruptedException  {

           //get data from table 
           List<List<String>> data = dataTable.raw();
           String EmpID = data.get(1).get(0);
           String period = data.get(1).get(1);

    browser.switchTo().frame(browser.findElement(By.id("main_target_win0")));

    }
  //find EmpID 
    WebElement inputEmpId = browser.findElement(By.name("EX_TIME_ADD_VW_EMPLID"));

    //fill in EmpID
    inputEmpId.clear();
    inputEmpId.sendKeys(EmpId);

    //find period
    WebElement inputPeriod = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));

    //set period date
    inputPeriod.clear();
    inputPeriod.sendKeys(period);

    //find a Add button
    WebElement addButton = browser.findElement(By.id("#ICSearch"));

    //click Add button
    addButton.click();


}

@And("^User creates a blank time report$")
public void user_creates_a_blank_time_report_ID() throws Exception {
    // find open blank ink
    WebElement blankLink = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));

    blankLink.click();
}

@And("^User fill project hours details$")
public void user_fill_project_hours_details_ID(DataTable projectTable) throws Exception {

    //get data for project hours
    List<List<String>> data = projectTable.raw();
    String project = data.get(1).get(0);
    String activity = data.get(1).get(1);  
    String category = data.get(1).get(2); 
    String monday = data.get(1).get(3); 
    String tuesday = data.get(1).get(4); 
    String wednesday = data.get(1).get(5); 
    String thursday = data.get(1).get(6);
    String friday = data.get(1).get(7);
}
}
