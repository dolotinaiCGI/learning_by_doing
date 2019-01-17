Feature: Timesheet creation  
   
   @timesheet 
   Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application with specified credentails
	   | Username * | Password * |
	   |  |  |
	   When User navigates to CGI Timesheet Reports
	   And User fill main time report details
	   | Empl ID *   | Period End Date * |
	   | LPS00333240 | 01/26/2019      |
	   And User creates a blank time report
	   And User added comment: "My comments"
	   And User fill project hours details
	   | Project *       | Activity * | su | mo | tu | we | th | fr | sa |
	   | 000000000110523 | L34_QA_ANA_SEN | 0 | 8 | 8 | 8 | 8 | 8 | 0 |
	   And User add attachments
	   | Attachment local path                                                             |
	   | C:\Users\sovap\Projects\learning_by_doing\src\test\java\binaries\attachment_1.txt |
	   | C:\Users\sovap\Projects\learning_by_doing\src\test\java\binaries\attachment_2.txt |
	   | C:\Users\sovap\Projects\learning_by_doing\src\test\java\binaries\attachment_3.txt |




#	   And User fill personal hours details for Administration
#	   | Sunday | Monday  | .. |
#	   | .. 		| ...			| .. |
#	   And User fill personal hours details for Training
#	   | Sunday | Monday  | .. |
#	   | .. 		| ...			| .. | 		