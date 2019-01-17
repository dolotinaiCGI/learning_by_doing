Feature: Timesheet creation  
   
   @timesheet 
   Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application
	   | username     | Password    |	 
	   | jason.adams  | ** |	
	   When User navigates to CGI Timesheet Reports
	   And User fill main time report details
	   | Empl ID *   | Period End Date * |
	   | LPS00316675 | 01/20/2019      |
	   And User creates a blank time report
	   And User added comment: "Comment"
	   And User fill project hours details
	   | Project *       | Activity * |
	   |                 |            |
	   And User add attachments
	   | Attachment local path |
	   |                       |
	   |                       |
	   |                       |