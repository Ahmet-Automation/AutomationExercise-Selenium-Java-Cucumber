package com.ahmett.pages;

import com.ahmett.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public BasePage () {

        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(xpath = "//a[contains(text(), ' Signup / Login')]")
   public WebElement signupLoginButton;
    /*
    @FindBy(linkText = " Signup / Login")
    public WebElement loginSignupButton;
     */

    @FindBy(css = "button.fc-cta-consent")
    public WebElement cookieConsent;

    @FindBy(xpath = "//a[contains(@href, '/logout')]")
    public WebElement logoutButton;


    public void acceptCookies() {

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(cookieConsent)).click();
        } catch (Exception e) {

        }

    }

}


