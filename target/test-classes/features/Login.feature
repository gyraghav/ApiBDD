Feature: Application Login

Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with uname and password pwd
Then Home page is papulated
And Cards are displayed are true

