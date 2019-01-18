package steps;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import framework.DriverUtil;
import framework.Helpers;
import framework.Wrappers;

public class timesheet_steps {
				
	WebDriver browser = DriverUtil.getDriver();
	
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails() throws Exception {
	    
		
		// get the url and credentials from the classified.txt file 
		ArrayList<String> classifiedInfo = Helpers.getClassifiedInformation();
		
		String timesheetUrl = classifiedInfo.get(0);
		String username = classifiedInfo.get(1);
		String password = classifiedInfo.get(2);
		
		// navigate to timesheet login page
		browser.get(timesheetUrl);
		
			
		// find the web element for the username
		WebElement inputUsername = browser.findElement(By.id("userid"));
		
		
		//fill the username
		inputUsername.clear();
		inputUsername.sendKeys(username);
		
		WebElement inputPassword = browser.findElement(By.id("pwd"));
		
		//fill the password
		inputPassword.clear();
		inputPassword.sendKeys(password);
				
		// click on the login button
		WebElement buttonLogin = browser.findElement(By.name("Submit"));
				
		// submit the login
		buttonLogin.click(); 
		
		// verify that everything is ok:
		WebElement buttonReports = browser.findElement(By.id("win0groupletPTNUI_LAND_REC_GROUPLET$0"));
		assertTrue(buttonReports.isDisplayed());		
		
	
	}

	@And("^User navigates to CGI Timesheet Reports$")
	public void user_navigates_to_cgi_timesheet_reports() {
		
	WebElement buttonTile = browser.findElement(By.id("PS_REPORT_TIME_L_FL$0"));
	buttonTile.click(); 
	
		
	}
	
	@And("^User fill main time report details$")
	public void user_fill_main_time_report_details(DataTable DatesTable) throws Exception {
	
	// get the credentials data from scenario
	List<List<String>> data = DatesTable.raw();	
	String emplid = data.get(1).get(0);
	String enddate = data.get(1).get(1);
	
	browser.switchTo().frame(browser.findElement(By.id("main_target_win0")));
	WebElement inputEmplid = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
	
	//fill the empl id
	inputEmplid.clear();
	inputEmplid.sendKeys(emplid);
	
	WebElement inputDate = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));
	inputDate.clear();
	inputDate.sendKeys(enddate);
	
	
	//button add

	WebElement buttonAdd = browser.findElement(By.id("#ICSearch"));	
	buttonAdd.click();	
	
	}
	
	@And("^User creates a blank time report$")
	public void user_creates_a_blank_time_report() throws Exception {

	WebElement linkBlank = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));	
	linkBlank.click();
	
	}
	
	@And("^User fill project hours detail$")
	public void user_fill_project_hours_detail(DataTable ProjectTable) throws Exception {
	    
		// get the project data from scenario
		List<List<String>> data = ProjectTable.raw();	
		String projid = data.get(1).get(0);
		String activity = data.get(1).get(1);
		String category = data.get(1).get(2);
		String mo = data.get(1).get(3);
		String tu = data.get(1).get(4);
		String we = data.get(1).get(5);
		String th = data.get(1).get(6);
		String fr = data.get(1).get(7);
		
		
		WebElement inputProjId = browser.findElement(By.id("PROJECT_CODE$0"));
		inputProjId.clear();
		inputProjId.sendKeys(projid);	
		
		
		//primo input fields activity id vepsat
		//WebElement inputActId = browser.findElement(By.id("ACTIVITY_CODE$0"));
		//inputActId.click();
		//inputActId.sendKeys(activity);
		
		//aktivity pres lupicku:
		WebElement inputActId = browser.findElement(By.id("ACTIVITY_CODE$prompt$img$0"));
		inputActId.click();
	
		//inputProjId.sendKeys(Keys.ENTER);
				
		//pokus s javascriptem
//		JavascriptExecutor jse = (JavascriptExecutor)browser;
//		jse.executeScript("arguments[0].value='gjhgj';", inputActId);
					
		 //vepsat aktivity ID
		browser.switchTo().defaultContent();
		browser.switchTo().frame(browser.findElement(By.xpath("//iframe[@title='Popup window']")));
		browser.findElement(By.linkText(activity)).click(); 
		browser.switchTo().defaultContent();
		
		//pop-up has to disappear
        Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");

		
        //going back to main frame
		browser.switchTo().frame(browser.findElement(By.id("main_target_win0")));

		//find Monday field
        WebElement inputMo = browser.findElement(By.id("TIME2$0"));
        inputMo.click();
        
        // vyplnit pondeli
        inputMo.sendKeys(mo);

		
      //najit utery
        WebElement inputTu = browser.findElement(By.id("TIME3$0"));
        inputTu.click();
                     
        //vyplnit utery
        inputTu.sendKeys(tu);
        
        //najit stredu
        WebElement inputWe = browser.findElement(By.id("TIME4$0"));
        inputWe.click();
                                  
        //vyplnit stredu
        inputWe.sendKeys(we);
        
        //najit ctvrtek
        WebElement inputTh = browser.findElement(By.id("TIME5$0"));
        inputTh.click();
                                  
        //vyplnit ctvrtek
        inputTh.sendKeys(th);
        
        //najit patek
        WebElement inputFr = browser.findElement(By.id("TIME6$0"));
        inputFr.click();
                                              
        //vyplnit patek
        inputFr.sendKeys(fr, Keys.ENTER);
        
	
	}
	
	

}

