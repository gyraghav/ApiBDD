Feature: Testing some examples on RESREQ

Scenario: Get the list of users info
	When I get the following API endpoint to create user
	| name               | job                  |
	| RAJ				 |SDET					|
	
	Then user list will be displayed 
	Then Validate the status code 200
	
