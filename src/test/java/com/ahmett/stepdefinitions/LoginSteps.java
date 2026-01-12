package com.ahmett.stepdefinitions;

import com.ahmett.pages.LoginPage;
import com.ahmett.pages.RegistrationPage;
import com.ahmett.utils.Driver;
import com.ahmett.utils.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class LoginSteps {

    // Page objects initialized at the top for clean access
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    private final String EXCEL_PATH = "src/test/resources/TestData.xlsx";

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        Driver.getDriver();
    }

    @And("I navigate to url {string}")
    public void i_navigate_to_url(String url) {
        Driver.getDriver().get(url);
        loginPage.acceptCookies();
    }

    @Then("I verify that home page is visible successfully")
    public void i_verify_that_home_page_is_visible_successfully() {
        String title = Driver.getDriver().getTitle();
        Assertions.assertTrue(title.contains("Automation Exercise"), "Title mismatch!");
    }

    @When("I click on {string} button")
    public void i_click_on_button(String buttonText) {
        loginPage.signupLoginButton.click();
    }

    @Then("I verify that {string} header is visible")
    public void i_verify_that_header_is_visible(String expectedText) {
        Assertions.assertTrue(loginPage.isLoginHeaderVisible(), "Login header is not visible!");
    }

    @And("I click {string} button")
    public void i_click_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("login")) {
            loginPage.loginButton.click();
        }
    }

    @Then("I verify that {string} text is visible")
    public void i_verify_that_text_is_visible(String loggedInAsText) {
        Assertions.assertTrue(loginPage.loggedInAsText.isDisplayed(),
                "Login failed: 'Logged in as' text is not visible.");
    }

    @When("I click the {string} link")
    public void i_click_logout_link(String buttonName) {
        if (buttonName.equalsIgnoreCase("Logout")) {
            loginPage.logoutButton.click();
        }
    }

    @Then("I verify that user is navigated to login page")
    public void i_verify_that_user_is_navigated_to_login_page() {
        Assert.assertTrue("Login header is not visible!", loginPage.isLoginHeaderVisible());
    }

    // --- Excel Integrated Methods ---

    @When("I login using credentials from excel sheet {string} at row {int}")
    public void i_login_using_credentials_from_excel_sheet_at_row(String sheetName, Integer rowNumber) {
        ExcelUtil excel = new ExcelUtil(EXCEL_PATH, sheetName);
        Map<String, String> data = excel.getDataList().get(rowNumber - 1);

        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(data.get("username"));
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(data.get("password"));
        loginPage.loginButton.click();
    }

    @Then("I verify that {string} with username from row {int} is visible")
    public void verifyUsername(String expectedText, Integer rowNumber) {
        ExcelUtil excel = new ExcelUtil(EXCEL_PATH, "TestData");
        String expectedUsername = excel.getDataList().get(rowNumber - 1).get("name");

        String actualFullText = loginPage.loggedInAsText.getText();
        Assert.assertTrue("ERROR: Username " + expectedUsername + " not found in text: " + actualFullText,
                actualFullText.contains(expectedUsername));
    }

    @Then("I verify that {string} error message is visible")
    public void verifyErrorMessage(String expectedError) {
        Assert.assertTrue("ERROR: Error message is not displayed!", loginPage.errorMessage.isDisplayed());
        String actualError = loginPage.errorMessage.getText();
        Assert.assertEquals("ERROR: Error message mismatch!", expectedError, actualError);
    }

    @When("I register a new user using data from excel sheet {string} at row {int}")
    public void i_register_a_new_user_using_data_from_excel_sheet_at_row(String sheetName, Integer rowNumber) {
        ExcelUtil excel = new ExcelUtil(EXCEL_PATH, sheetName);
        Map<String, String> data = excel.getDataList().get(rowNumber - 1);

        // Step 1: Initial Signup
        loginPage.signupName.sendKeys(data.get("name"));
        loginPage.signupEmail.sendKeys(data.get("username"));
        loginPage.signupButton.click();

        // Step 2: Form Details
        registrationPage.titleMr.click();
        registrationPage.passwordField.sendKeys(data.get("password"));

        new Select(registrationPage.daysDropdown).selectByVisibleText("10");
        new Select(registrationPage.monthsDropdown).selectByVisibleText("May");
        new Select(registrationPage.yearsDropdown).selectByVisibleText("1990");

        registrationPage.firstNameField.sendKeys(data.get("name"));
        registrationPage.lastNameField.sendKeys("TestUser");
        registrationPage.addressField.sendKeys("101 Automation St");
        registrationPage.countryDropdown.sendKeys("United States");
        registrationPage.stateField.sendKeys("New York");
        registrationPage.cityField.sendKeys("New York");
        registrationPage.zipcodeField.sendKeys("10001");
        registrationPage.mobileNumberField.sendKeys("1234567890");

        registrationPage.createAccountButton.click();
    }

    @Then("I verify that account is created successfully")
    public void i_verify_that_account_is_created_successfully() {
        Assert.assertTrue("ERROR: 'Account Created!' message is NOT visible!",
                registrationPage.accountCreatedMessage.isDisplayed());
    }
}
