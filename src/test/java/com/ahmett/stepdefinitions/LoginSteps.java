package com.ahmett.stepdefinitions;

import com.ahmett.pages.LoginPage;
import com.ahmett.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

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
        Assertions.assertTrue(title.contains("Automation Exercise"));
    }

    @When("I click on {string} button")
    public void i_click_on_button (String buttonText) {
        loginPage.signupLoginButton.click();
    }

    @Then("I verify that {string} header is visible")
    public void i_verify_that_header_is_visible (String expectedText) {
        Assertions.assertTrue(loginPage.isLoginHeaderVisible());
    }

    @When("I enter correct email address and password")
    public void i_enter_correct_email_address_and_password() {
        loginPage.emailInput.sendKeys("ahmet.qa.at@gamil.com");
        loginPage.passwordInput.sendKeys("SecurePass123");
    }

    @And("I click {string} button")
    public void i_click_button(String buttonName) {
        if(buttonName.equalsIgnoreCase("login")) {
            loginPage.loginButton.click();
        }
    }

    @Then("I verify that {string} text is visible")
    public void i_verify_that_text_is_visible(String loggedInAsText) {
        // We directly verify the element that contains 'Logged in as'
        Assertions.assertTrue(loginPage.loggedInAsText.isDisplayed(),
                "Login failed: 'Logged in as' text is not visible on the page.");
    }

    // Logout User

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




}
