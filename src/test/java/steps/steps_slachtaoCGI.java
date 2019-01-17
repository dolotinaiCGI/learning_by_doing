package steps;


import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.DriverUtil;
import framework.Wrappers;

public class steps_slachtaoCGI {
	
	// get the driver:
	WebDriver browser = DriverUtil.getDriver();
	
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails(DataTable credentialsTable) throws Exception {
	    
		
		// navigate to timesheet login page
		browser.get("https://psa-fs.ent.cgi.com/psc/fsprda/EMPLOYEE/ERP/c/NUI_FRAMEWORK.PT_LANDINGPAGE.GBL?");
		
		// get the credentials data from scenario
		List<List<String>> data = credentialsTable.raw();
		
		
		String username = data.get(1).get(0);
		String password = data.get(1).get(1);
		
		/*
		System.out.println("cred table");
		System.out.println(credentialsTable);
		System.out.println("");
		
		System.out.println("data");
		System.out.println(data);
		System.out.println("");
		
		System.out.println("from data get 0");
		System.out.println(data.get(0) );
		System.out.println("");
		 */
		
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
		WebElement buttonReports = browser.findElement(By.id("win0divPTNUI_LAND_REC_GROUPLET$0"));
		assertTrue(buttonReports.isDisplayed());
		
	}

	@When("^User navigates to CGI Timesheet Reports$")
	public void user_navigates_to_CGI_Timesheet_Reports() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	 
		// locate the time reports button element
		WebElement buttonTimeReports = browser.findElement(By.id("win0divPTNUI_LAND_REC_GROUPLET$0"));
		
		// click on the time reports button
		// System.out.println("clicking on the time reports button");
		buttonTimeReports.click();
				
		/*
		// wait a bit
		WebDriverWait wait = new WebDriverWait(browser, 30);
		browser.manage().timeouts().implicitlyWait(10, null );
		System.out.println("waiting 30 seconds");
		*/
		
		// change to the main iframe
		WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
		
		// verify that time reports page loaded
		WebElement inputEmplID = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
		assertTrue(inputEmplID.isDisplayed());
		
	}
	
	@When("^User fill main time report details$")
	public void user_fill_main_time_report_details(DataTable timeReportDetails) throws Exception {
		// fetch time report details from the argument (from the scenario)
		List<List<String>> details = timeReportDetails.raw();
		
		
		String emplId = details.get(1).get(0);
		String periodEndDate = details.get(1).get(1);
		
		// fill empl ID
		WebElement inputEmplId = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
		inputEmplId.clear();
		inputEmplId.sendKeys(emplId);
		
		
		// fill period end date
		WebElement inputPeriodEndDate = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));
		inputPeriodEndDate.clear();
		inputPeriodEndDate.sendKeys(periodEndDate);
		
		// click add button
		WebElement buttonAdd = browser.findElement(By.id("#ICSearch"));
		buttonAdd.click();


		
	}
	
	@When("^User creates a blank time report$")
	public void user_creates_a_blank_time_report() throws Exception {

		// click add button
		WebElement buttonAdd = browser.findElement(By.id("#ICSearch"));
		buttonAdd.click();
		
		// click open blank ...
		WebElement linkBlank = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));
		linkBlank.click();
	    
	}

	@When("^User added comment: \"([^\"]*)\"$")
	public void user_added_comment(String comment) throws Exception {
		
		// enter the comment
		WebElement textComments = browser.findElement(By.id("EX_TIME_HDR_COMMENTS"));
		textComments.clear();
		textComments.sendKeys(comment);
	    
	}

	@When("^User fill project hours details$")
	public void user_fill_project_hours_details(DataTable projetHours) throws Exception {
		
		// decode the data table from the argument
		List<List<String>> projectTime = projetHours.raw();
		
		
		String projectCode = projectTime.get(1).get(0);
		String activityCode = projectTime.get(1).get(1);
		String hoursSu = projectTime.get(1).get(2);
		String hoursMo = projectTime.get(1).get(3);
		String hoursTu = projectTime.get(1).get(4);
		String hoursWe = projectTime.get(1).get(5);
		String hoursTh = projectTime.get(1).get(6);
		String hoursFr = projectTime.get(1).get(7);
		String hoursSa = projectTime.get(1).get(8);
		
		// fill in project
		// id: PROJECT_CODE$0
		WebElement textProject = browser.findElement(By.id("PROJECT_CODE$0"));
		textProject.clear();
		textProject.sendKeys(projectCode);
						
		// wait a bit ?????
		Thread.sleep(10000);
		
		// change to the main iframe
				WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
				browser.switchTo().frame(mainIframe);
		
		
		
		// fill in activity
		// id: ACTIVITY_CODE$0
		WebElement textActivity = browser.findElement(By.id("ACTIVITY_CODE$0"));
		textActivity.clear();
		textActivity.sendKeys(activityCode);
		
		// change to the main iframe
				WebElement mainIframe2 = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
				browser.switchTo().frame(mainIframe2);
		
		// fill in the hours
		/*
		 TIME1$0
		 TIME2$0
		 ...
		 TIME7$0
		 
		 */
		WebElement textHoursSu = browser.findElement(By.id("TIME1$0"));
		textHoursSu.clear();
		textHoursSu.sendKeys(hoursSu);
		
		WebElement textHoursMo = browser.findElement(By.id("TIME2$0"));
		textHoursMo.clear();
		textHoursMo.sendKeys(hoursMo);
		
		WebElement textHoursTu = browser.findElement(By.id("TIME3$0"));
		textHoursTu.clear();
		textHoursTu.sendKeys(hoursTu);
		
		WebElement textHoursWe = browser.findElement(By.id("TIME4$0"));
		textHoursWe.clear();
		textHoursWe.sendKeys(hoursWe);
		
		WebElement textHoursTh = browser.findElement(By.id("TIME5$0"));
		textHoursTh.clear();
		textHoursTh.sendKeys(hoursTh);
		
		WebElement textHoursFr = browser.findElement(By.id("TIME6$0"));
		textHoursFr.clear();
		textHoursFr.sendKeys(hoursFr);
		
		WebElement textHoursSa = browser.findElement(By.id("TIME7$0"));
		textHoursSa.clear();
		textHoursSa.sendKeys(hoursSa);
		
		
		// stupid wait
		/*
		WebElement dummy = browser.findElement(By.id("non-existent"));
		dummy.sendKeys("xxx");
	    */
	}
	
	
	
}