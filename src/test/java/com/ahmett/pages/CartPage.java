package com.ahmett.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = "tr[id^='product-']")
    public List<WebElement> cartRows;

    @FindBy(css = ".cart_description h4 a")
    public List<WebElement> productNames;

    @FindBy(css = ".cart_price p")
    public List<WebElement> productPrices;

    @FindBy(css = ".cart_quantity button")
    public List<WebElement> productQuantities;

    @FindBy(css = ".cart_total_price")
    public List<WebElement> totalPrices;


}
