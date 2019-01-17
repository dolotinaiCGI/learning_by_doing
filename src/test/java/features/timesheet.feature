Feature: Timesheet creation  
   
   @timesheetno
   Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application with specified credentails
	   | Timesheet Url * | Username * | Password * |
	   |                 |            |            | 
	   When User navigates to CGI Timesheet Reports
	   And User fill main time report details
	   | Empl ID *   | Period End Date * |
	   |             |                   |
	   And User creates a blank time report
	   And User added comment: ""
	   And User fill project hours details
	   | Project *       | Activity * |
	   |                 |            |
	   And User add attachments
	   | Attachment local path |
	   |                       |
	   |                       |
	   |                       |