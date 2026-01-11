package com.ahmett.tests;

import com.ahmett.pages.AccountCreatedPage;
import com.ahmett.pages.LoginPage;
import com.ahmett.pages.RegistrationPage;
import com.ahmett.utils.ConfigurationReader;
import com.ahmett.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTest {

    LoginPage loginPage;
    RegistrationPage registrationPage;
    AccountCreatedPage accountCreatedPage;

    @BeforeEach
            public void setUp() {
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.acceptCookies();
    }

    @Test
    public void newUserSignupTest () {

        loginPage.signupLoginButton.click();

        loginPage.signupName.sendKeys("Ahmet");
        loginPage.signupEmail.sendKeys("ahmet.qa.at@gamil.com");
        loginPage.signupButton.click();

        System.out.println("-----------------------------------");

        Assertions.assertTrue(registrationPage.accountInfoTitle.isDisplayed());

        registrationPage.titleMr.click();
        registrationPage.passwordField.sendKeys("SecurePass123");

// Handle days, months and years ((Selecting an existing option - VisibleText)
        Select selectDays = new Select(registrationPage.daysDropdown);
        selectDays.selectByVisibleText("15");

        Select selectMonths = new Select(registrationPage.monthsDropdown);
        selectMonths.selectByVisibleText("February");

        Select selectYears = new Select(registrationPage.yearsDropdown);
        selectYears.selectByVisibleText("1990");

        Select selectCountry = new Select(registrationPage.countryDropdown);
        selectCountry.selectByVisibleText("United States");

        // Fill address information
        registrationPage.firstNameField.sendKeys("Ahmet");
        registrationPage.lastNameField.sendKeys("SDET");
        registrationPage.addressField.sendKeys("23 Selenium St, QA City");

        registrationPage.stateField.sendKeys("Virgina");
        registrationPage.cityField.sendKeys("fairfax");
        registrationPage.zipcodeField.sendKeys("22030");
        registrationPage.mobileNumberField.sendKeys("0123456789");

        // Click the button to complete registration
        registrationPage.createAccountButton.click();

        // Initialize the new page object
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage();

        // Verify successful registration
        String expectedMessage = "ACCOUNT CREATED!";
        String actualMessage = accountCreatedPage.accountCreatedMessage.getText();

        // Assertions ensure that the actual result matches our expectation
        Assertions.assertEquals(expectedMessage, actualMessage, "Registration failed or message mismatch!");

        // Click teh Continue button to go back to the homepage
        accountCreatedPage.continueButton.click();


    }

//    @AfterEach
//    public void tearDown() {
//        Driver.closeDriver();
//    }


}
