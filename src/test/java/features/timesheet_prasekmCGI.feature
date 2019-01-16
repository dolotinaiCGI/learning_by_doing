Feature: Timesheet creation  
   
   @timesheet 
   Scenario: User should be able to submit a new timesheet
	   Given User is logged in the timesheet application with specified credentails
	   When User navigates to CGI Timesheet Reports
	   And User fill main time report details
	   | Empl ID *   | Period End Date * |
	   | LPS00333922  | 01/18/2019       |
	   And User creates a blank time report
	   And User added comment: "my comment"
	   And User fill project hours details
	   | Project *       | Activity * | Monday  | Tuesday | Wednesday | Thursday | Friday |
	   | 300000000009805 |    3		    |  8	    | 8	      | 8         | 8        | 8      |
	   And User add attachments
	   | Attachment local path                                                             |
	   | C:\Users\prasekm\Projects\learning_by_doing\src\test\java\binaries\attachment_1.txt |
	   | C:\Users\prasekm\Projects\learning_by_doing\src\test\java\binaries\attachment_2.txt |
	   | C:\Users\prasekm\Projects\learning_by_doing\src\test\java\binaries\attachment_3.txt |
	   And User fills non-project hours detail
	   | Description                    | Monday | Tuesday | Wednesday | Thursday | Friday |
	   | Administration									| 1      | 2       | 3         | 4        | 5      |
		 | Training												| 6      | 7       | 8         | 9        | 1      |
  	 | Proposal												| 0      | 0       | 0         | 0        | 0      |
     | In Between Assignments					| 0      | 0       | 0         | 0        | 0      |
     | Quality Assurance							| 0      | 0       | 0         | 0        | 0      |
     | Statutory Holiday							| 0      | 0       | 0         | 0        | 0      |
     | Vacation												| 1      | 2       | 3         | 4        | 5      |
     | Sick Leave- No doctors letter	| 8      | 8       | 8         | 8        | 8      |
     | Sick Leave											| 8      | 8       | 8         | 8        | 8      |
     | Bereavement Leave							| 8      | 8       | 8         | 8        | 8      |
     | Work Injury Leave							| 8      | 8       | 8         | 8        | 8      |
     | Personal Authorized Leave			| 8      | 8       | 8         | 8        | 8      |
     | Paternity Leave								| 8      | 8       | 8         | 8        | 8      |
     | Family Support Leave					  | 8      | 8       | 8         | 8        | 8      |
     | Administrative Leave						| 8      | 8       | 8         | 8        | 8      |
     | Unpaid Leave										| 8      | 8       | 8         | 8        | 8      |
     | Unauthorized/Unpaid Leave			| 8      | 8       | 8         | 8        | 8      |
     | Leave Without Pay							| 8      | 8       | 8         | 8        | 8      |
     | Carers Leave										| 8      | 8       | 8         | 8        | 8      |
