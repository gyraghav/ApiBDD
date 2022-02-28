Feature: Testing some examples on RESREQ

@Createuser
Scenario: Verify create user

  When I am able to get the following end point 
  | url                     | endpoint                     |
  | QA.userServices | users.create |

  And I send request for create user with below details
 | name          | job    |
 | Raju          | SDET   | 
 
  Then I should see user created successfully 
  When I am able to get the following API endpoint
  | url                     | endpoint              |
  | QA.userServices        | users.get |

  And I send get request for created user 
  Then I should see newly created user details in response
  Then I should see user fetched successfully
    
#GET USER:
@GetUser
Scenario: Verify Get user
Given I send request for create user with below details
 | name          | job    |
 | Raju          | SDET   | 

  When I am able to get the following API endpoint
  | url             | endpoint   |
  | QA.userServices | users.get  |

  And I send get request for user “TestId”
 # Then I should see user fetched successfully
  Then I should see newly created user details in response
