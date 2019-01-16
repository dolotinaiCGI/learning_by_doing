package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.DriverUtil;
import framework.Wrappers;
import framework.Helpers;

public class timesheet_steps_prasekmCGI {
	
	
	
	
	@Given("^User is logged in the timesheet application with specified credentails$")
	public void user_is_logged_in_the_timesheet_application_with_specified_credentails() throws Exception {
				
		WebDriver browser = DriverUtil.getDriver();
		
		// get the url and credentials from the classified.txt file 
		ArrayList<String> classifiedInfo = Helpers.getClassifiedInformation();
		
		String timesheetUrl = classifiedInfo.get(0);
		String username = classifiedInfo.get(1);
		String password = classifiedInfo.get(2);
		
		// navigate to the timesheet url
		browser.get(timesheetUrl);
		
		WebElement inputUsername = browser.findElement(By.id("userid"));
		inputUsername.clear();
		inputUsername.sendKeys(username);
			
		WebElement inputPassword = browser.findElement(By.id("pwd"));
		inputPassword.clear();
		inputPassword.sendKeys(password);
			
		WebElement buttonLogin = browser.findElement(By.name("Submit"));
		buttonLogin.click();
		
		
		WebElement result = browser.findElement(By.xpath("//*[@id=\"PTNUI_LAND_WRK_GROUPBOX14$PIMG\"]/span[1]"));
	
		// Assertion type #1: check if the text is present on page		
		String resultText = result.getText();
		assertEquals(resultText, "PSA Finance");
		
		// Assertion type #2: check if the object is displayed on page
		assertTrue(result.isDisplayed());		
		
	}


	@When("^User navigates to CGI Timesheet Reports$")
	public void user_navigates_to_CGI_Timesheet_Reports() throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();

		WebElement cgiTimeReportsButton = browser.findElement(By.id("win0divPTNUI_LAND_REC_GROUPLET$0"));
		cgiTimeReportsButton.click();
		
		WebElement cgiTimeReportsTitle = browser.findElement(By.id("PT_PAGETITLElbl"));
		String cgiTimeReportsTitle_Text = cgiTimeReportsTitle.getText();
		assertEquals(cgiTimeReportsTitle_Text, "CGI Time Reports");
		
	}
	
	
	@And("^User fill main time report details$")
	public void user_fill_main_time_report_details(DataTable emplIDPeriodTable) throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();
		
		List<List<String>> data = emplIDPeriodTable.raw();
		String emplID = data.get(1).get(0);
		String periodEndDate = data.get(1).get(1);
		
		WebElement myIframe = browser.findElement(By.xpath("//iframe"));
		browser.switchTo().frame(myIframe);
		
		WebElement input_emplID = browser.findElement(By.id("EX_TIME_ADD_VW_EMPLID"));
		input_emplID.clear();
		input_emplID.sendKeys(emplID);	
		
		WebElement input_periodEndDate = browser.findElement(By.id("EX_TIME_ADD_VW_PERIOD_END_DT"));
		input_periodEndDate.clear();
		input_periodEndDate.sendKeys(periodEndDate);	
				
	}

	@And("^User creates a blank time report$")
	public void user_creates_a_blank_time_report() throws Exception {

		WebDriver browser = DriverUtil.getDriver();
		
		WebElement addButton = browser.findElement(By.id("#ICSearch"));
		addButton.click();
				
		WebElement openBlankLink = browser.findElement(By.id("EX_ICLIENT_WRK_OK_PB"));
		openBlankLink.click();
		
//		Explicit Wait:		
		WebDriverWait wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EX_TIME_HDR_COMMENTS_LBL")));
		
		
		WebElement summaryTitle = browser.findElement(By.id("EX_ICLIENT_WRK_PAGE_TITLE_60"));
		String text_summaryTitle = summaryTitle.getText();
		
		assertEquals("Time Report Summary", text_summaryTitle);
		
	}
	
	
	@And("^User added comment: \"([^\"]*)\"$")
	public void user_added_comment(String commentText) throws Exception {

		WebDriver browser = DriverUtil.getDriver();
		
		WebElement input_comment = browser.findElement(By.id("EX_TIME_HDR_COMMENTS"));
		input_comment.clear();
		input_comment.sendKeys(commentText);
		
	}

	
	@And("^User fill project hours details$")
	public void user_fill_project_hours_detail(DataTable projectTable) throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();
		
		List<List<String>> data = projectTable.raw();
		String project = data.get(1).get(0);
		String activity = data.get(1).get(1);
		String monday = data.get(1).get(2);
		String tuesday = data.get(1).get(3);
		String wednesday = data.get(1).get(4);
		String thursday = data.get(1).get(5);
		String friday = data.get(1).get(6);

		WebElement lookUpProjectIcon = browser.findElement(By.id("PROJECT_CODE$prompt$img$0"));
		lookUpProjectIcon.click();
		
		browser.switchTo().defaultContent();
		WebElement popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
		
		WebElement linkProject = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + project +  "']"));
		linkProject.click();
		browser.switchTo().defaultContent();
		
		// waiting for the popup window to close
		Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");
		
		
		// change to the main iframe
		WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);

		
		WebElement lookUpActivityIcon = browser.findElement(By.id("ACTIVITY_CODE$prompt$img$0"));
		lookUpActivityIcon.click();

		browser.switchTo().defaultContent();
		popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
		
		
		// select activity
		WebElement linkActivity = browser.findElement(By.xpath("//table[@id='PTSRCHRESULTS']//a[text()='" + activity + "']"));
		linkActivity.click();
		browser.switchTo().defaultContent();
		
		// waiting for the popup window to close
		Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");
		
		
		// change to the main iframe
		mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);



		WebElement input_monday = browser.findElement(By.id("TIME2$0"));
		input_monday.clear();
		input_monday.sendKeys(monday);
		
		WebElement input_tuesday = browser.findElement(By.id("TIME3$0"));
		input_tuesday.clear();
		input_tuesday.sendKeys(tuesday);
		
		WebElement input_wednesday = browser.findElement(By.id("TIME4$0"));
		input_wednesday.clear();
		input_wednesday.sendKeys(wednesday);
		
		WebElement input_thursday = browser.findElement(By.id("TIME5$0"));
		input_thursday.clear();
		input_thursday.sendKeys(thursday);
		
		WebElement input_friday = browser.findElement(By.id("TIME6$0"));
		input_friday.clear();
		input_friday.sendKeys(friday);
		
			
	}

	
	@And("^User add attachments$")
	public void user_add_attachments(DataTable attachmentsTable) throws Exception {

		WebDriver browser = DriverUtil.getDriver();
		
		WebElement attachmentsLink = browser.findElement(By.id("UC_EX_WRK_ATTACHMENT_PB$323$"));
		attachmentsLink.click();
		
		// get the lists from the table
		List<List<String>> data = attachmentsTable.raw();
		
		// get the number of attachments
		int numOfAttach = data.size() - 1;
		
//---------------------------------------------------------------------------------------------------------------------------------------------		
		
		for (int i = 0; i < numOfAttach; i++) {
		
		// click on Add Attachment button
		WebElement addAttachment = browser.findElement(By.id("UC_TI_ATTAC_WRK_ATTACHADD$" + i));
		addAttachment.click();
		
		// switch to popup iframe		
		browser.switchTo().defaultContent();
		WebElement popupIframe = browser.findElement(By.xpath("//iframe[@title='Popup window']"));
		browser.switchTo().frame(popupIframe);
		
		//get a url from the list
		String path = data.get(i + 1).get(0);
		WebElement browseButton = browser.findElement(By.name("#ICOrigFileName"));
		browseButton.sendKeys(path);
		
		// click on the upload button
		WebElement uploadButton = browser.findElement(By.name("Upload"));
		uploadButton.click();
		browser.switchTo().defaultContent();
		
		// wait for popup to close
		Wrappers.waitForElementToDisappear("//iframe[@title='Popup window']");
		
		// switch to main iframe
		browser.switchTo().defaultContent();
		WebElement mainIframe = browser.findElement(By.xpath("//iframe[@title='Main Content']"));
		browser.switchTo().frame(mainIframe);
				
		// add another row
		WebElement addIcon = browser.findElement(By.id("UC_FILE_UPL_TM$new$" + i + "$$0"));
		addIcon.click();
	
		}
		
//		UC_TI_ATTAC_WRK_ATTACHADD$1
//		UC_FILE_UPL_TM$new$1$$0
//		UC_TI_ATTAC_WRK_ATTACHADD$2

//---------------------------------------------------------------------------------------------------------------------------------------------		

		Thread.sleep(2000);
		
		WebElement doneButton = browser.findElement(By.id("UC_EX_WRK_UC_DONE_PB$0"));
		doneButton.click();

		
		Thread.sleep(10000);
		
	}
	
	
	@And("^User fills non-project hours detail$")
	public void user_fills_non_project_hours_detail(DataTable nonProjectTable) throws Exception {
		
		WebDriver browser = DriverUtil.getDriver();
		
		WebElement hyperlink_viewAll = browser.findElement(By.id("EX_TRC_MAP_VW$hviewall$0"));
		hyperlink_viewAll.click();

//		Explicit Wait:		
		WebDriverWait wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POL_TIME2$5")));
		
		
		List<List<String>> data = nonProjectTable.raw();
		
		for (int i = 0; i < 19; i++) {
		      
			for (int j = 2; j < 7; j++) {

//			 System.out.println("POL_TIME" + j + "$" + i);
//			 System.out.println("data.get(" + (i + 1) + ").get(" + (j - 1) + ")");
		     
			 WebElement identification = browser.findElement(By.id("POL_TIME" + j + "$" + i));
			 identification.clear();
			 identification.sendKeys(data.get(i + 1).get(j - 1));

			}
	    }
		
		
		Thread.sleep(5000);
	
		
	}
	
}