@login
Feature: Login Functionality
  Scenario: Login User with correct email and password
    Given I launch the browser
    And I navigate to url "http://automationexercise.com"
    Then I verify that home page is visible successfully
    When I click on "Signup / Login" button
    Then I verify that "Login to your account" header is visible
    When I enter correct email address and password
    And I click "login" button
   Then I verify that "Logged in as username" text is visible




