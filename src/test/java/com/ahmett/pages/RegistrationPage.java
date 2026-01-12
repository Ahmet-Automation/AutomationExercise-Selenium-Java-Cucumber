package com.ahmett.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    // --- Section 1: Account Information ---

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement accountInfoTitle;

    @FindBy(id = "id_gender1")
    public WebElement titleMr;

    @FindBy(id = "password")
    public WebElement passwordField;

    // These will require the 'Select' class in our test
    @FindBy(id = "days")
    public WebElement daysDropdown;

    @FindBy(id = "months")
    public WebElement monthsDropdown;

    @FindBy(id = "years")
    public WebElement yearsDropdown;

    // --- Section 2: Address Information ---

    @FindBy(id = "first_name")
    public WebElement firstNameField;

    @FindBy(id = "last_name")
    public WebElement lastNameField;

    @FindBy(id = "address1")
    public WebElement addressField;

    @FindBy(id = "country")
    public WebElement countryDropdown;

    @FindBy(id = "state")
    public WebElement stateField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "zipcode")
    public WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;


}



