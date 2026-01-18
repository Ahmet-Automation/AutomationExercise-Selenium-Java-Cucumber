package com.ahmett.pages;

import com.ahmett.utils.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    // Locators for the first product
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "(//a[@data-product-id='1'])[2]")
    public WebElement addToCartFirst;

    // Locators for the second product
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[2]")
    public WebElement secondProduct;

    @FindBy(xpath = "(//a[@data-product-id='2'])[2]")
    public WebElement addToCartSecond;


    // Modal elements
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//u[text()='View Cart']")
    public WebElement viewCartLink;

    // Actions
    public void hoverAndClickFirstProduct() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(firstProduct).perform();
        addToCartFirst.click();
    }

//    public void hoverAndClickSecondProduct() {
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(secondProduct).perform();
//        addToCartSecond.click();
//    }


    public void hoverAndClickSecondProduct () {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(secondProduct).perform();

        // JS click
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", addToCartSecond);
    }

    // Locators for quantity test
    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    public WebElement viewProductFirst;

    @FindBy(id = "quantity")
    public WebElement quantityInput;

    @FindBy(xpath = "//button[contains(@class,'cart')]")
    public WebElement addToCartButton;

    public void clickAddToCartFromDetails() {
        // Handling potential overlays with JS Click
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", addToCartButton);
    }



}
