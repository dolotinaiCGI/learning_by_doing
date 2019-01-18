Feature: Timesheet creation  
   
   @timesheet   
   Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application with specified credentails
#	 	| Timesheet Url * | Username * 		| Password * |
		
	   And User navigates to CGI Timesheet Reports
	   And User fill main time report details
	   | Empl ID     | Period End Date |
	   |  | 12/02/2019      |
	   And User creates a blank time report
	   And User fill project hours detail
	   | Project  			| Activity	| Category		| Mo |Tu | We | Th | Fr |
	   |000000000106720		|DE-DELIVERY| 10100  		| 8  | 8 | 8  | 8  | 8	|
#	   And User fill personal hours details for Administration
#	   | Sunday | Monday  | .. |
#	   | .. 		| ...			| .. |
#	   And User fill personal hours details for Training
#	   | Sunday | Monday  | .. |
#	   | .. 		| ...			| .. | 	




#	   And User added comment: ""

#	   And User add attachments
#	   | Attachment local path |
#	   |                       |
#	   |                       |
#	   |                       |

