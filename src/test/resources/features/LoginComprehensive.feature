@LoginComprehensive
Feature: Comprehensive User Management with Excel

  @PositiveLogin
  Scenario: Login with existing user from Excel
    Given I launch the browser
    And I navigate to url "https://automationexercise.com"
    When I click on "Signup / Login" button
    And I login using credentials from excel sheet "TestData" at row 1
    Then I verify that "Logged in as" with username from row 1 is visible

  @NegativeLogin
  Scenario: Login with incorrect credentials from Excel
    Given I launch the browser
    And I navigate to url "https://automationexercise.com"
    When I click on "Signup / Login" button
    And I login using credentials from excel sheet "TestData" at row 2
    Then I verify that "Your email or password is incorrect!" error message is visible

  @RegistrationAndLogin
  Scenario: Register a new user from Excel and then login
    Given I launch the browser
    And I navigate to url "https://automationexercise.com"
    When I click on "Signup / Login" button
    And I register a new user using data from excel sheet "TestData" at row 3
    Then I verify that account is created successfully

