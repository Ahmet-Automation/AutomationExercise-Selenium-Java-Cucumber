package com.ahmett.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    // "New User Signup" elements
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountHeader;

    // Inside LoginPage class

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Logged in as')]")
    public WebElement loggedInAsText;

    @FindBy(xpath = "//p[contains(text(),'incorrect')]") public WebElement errorMessage;

    public boolean isLoginHeaderVisible () {
        return loginToYourAccountHeader.isDisplayed();
    }

}
