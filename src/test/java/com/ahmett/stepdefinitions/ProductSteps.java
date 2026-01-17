package com.ahmett.stepdefinitions;

import com.ahmett.pages.CartPage;
import com.ahmett.pages.ProductsPage;
import com.ahmett.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSteps {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @When("I click on {string} link from the header menu")
    public void i_click_on_link_from_the_header_menu(String linkName) {
        // Specifically targeting the anchor tags inside the header for precision
        String xpath = "//header//a[contains(text(), '" + linkName + "')]";
        WebElement headerLink = Driver.getDriver().findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.elementToBeClickable(headerLink)).click();
    }

    @And("I hover over first product and click {string}")
    public void i_hover_over_first_product_and_click(String buttonText) {
        productsPage.hoverAndClickFirstProduct();
    }


    @And("I click on {string} button in the modal")
    public void i_click_on_button_in_the_modal(String buttonName) {
        if (buttonName.equalsIgnoreCase("Continue Shopping")) {
            wait.until(ExpectedConditions.elementToBeClickable(productsPage.continueShoppingButton)).click();
        } else if (buttonName.equalsIgnoreCase("View Cart")) {
            wait.until(ExpectedConditions.elementToBeClickable(productsPage.viewCartLink)).click();
        }
    }

    @And("I hover over second product and click {string}")
    public void i_hover_over_second_product_and_click(String buttonText) {
        productsPage.hoverAndClickSecondProduct();
    }

    @Then("I verify both products are added to Cart")
    public void i_verify_both_products_are_added_to_cart() {
        // Verifying that the list of rows in the cart equals 2
        Assert.assertEquals("ERROR: Product count in cart mismatch!", 2, cartPage.cartRows.size());
    }

    @And("I verify their prices, quantity and total price")
    public void i_verify_their_prices_quantity_and_total_price() {
        // Basic verification to ensure elements are displayed
        // This can be enhanced by comparing actual values from Excel or site logic
        Assert.assertTrue("Prices are not visible!", cartPage.productPrices.get(0).isDisplayed());
        Assert.assertTrue("Quantities are not visible!", cartPage.productQuantities.get(0).isDisplayed());
        Assert.assertTrue("Total prices are not visible!", cartPage.totalPrices.get(0).isDisplayed());
    }


}
