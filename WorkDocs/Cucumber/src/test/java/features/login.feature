Feature: SSP Login


Scenario: Login successfully to SSP main application
Given User is on Signin page "https://sit-maine.cs32.force.com/benefits/s/signin?language=en_US"
When Enter username and password
Then User should be logged in to application and land on Dashboard screen

