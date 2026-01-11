package com.ahmett.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    public AccountCreatedPage () {
        super();
    }

    // Elements for the success page after clicking "Create Account"
    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;


}
