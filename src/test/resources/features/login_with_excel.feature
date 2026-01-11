@LoginWithExel
  Feature: Login Functionality with Excel

    # This scenario demonstrates how to fetch data from an external Excel file
  # It separates test logic from test data
    Scenario Outline: Login with multiple users from Excel
      Given I launch the browser
      And I navigate to url "https://automationexercise.com"
      When I click on "Signup / Login" button
      And I login using credentials from excel sheet "<SheetName>" at row <RowNumber>
      Then I verify that "Logged in as" text is visible

      Examples:
        | SheetName | RowNumber |
        | TestData    | 1         |
