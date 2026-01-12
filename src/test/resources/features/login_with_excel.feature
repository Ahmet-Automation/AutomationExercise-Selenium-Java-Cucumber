@LoginWithExel
Feature: Login Functionality with Excel

  Scenario Outline: Login with multiple users from Excel
    Given I launch the browser
    And I navigate to url "https://automationexercise.com"
    When I click on "Signup / Login" button

    And I login using credentials from excel sheet "<SheetName>" at row <RowNumber>
    Then I verify that "Logged in as" with username from row <RowNumber> is visible
    And I click the "Logout" link

    Examples:
      | SheetName | RowNumber |
      | TestData  | 1         |
      | TestData  | 2         |
      | TestData  | 3         |

