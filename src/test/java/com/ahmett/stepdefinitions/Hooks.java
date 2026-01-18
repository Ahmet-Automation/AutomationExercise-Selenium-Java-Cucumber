package com.ahmett.stepdefinitions;

import com.ahmett.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        // Check if the scenario failed
        if (scenario.isFailed()) {
            // Take a screenshot as a byte array
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // Attach the screenshot to the HTML report
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        /// Close the driver after each scenario to keep it clean
        Driver.closeDriver();
    }
}
