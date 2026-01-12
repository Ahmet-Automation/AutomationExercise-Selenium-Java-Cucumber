package com.ahmett.stepdefinitions;

import com.ahmett.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {

        // This ensures the browser closes and resets for the next Excel row
        Driver.closeDriver();
    }
}
