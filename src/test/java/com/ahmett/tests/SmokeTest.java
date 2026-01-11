package com.ahmett.tests;

import com.ahmett.utils.ConfigurationReader;
import com.ahmett.utils.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmokeTest {

    @Test
    public void mainPageAccessibilityTest() {
        // 1. Get the URL from the configuration.properties file
        String url = ConfigurationReader.getProperty("url");
        System.out.println("Navigate to: " + url);

        // 2. Open the browser and navigate to the website
        Driver.getDriver().get(url);

        // 3.  Verify the title to ensure the page is loaded correctly
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();

        System.out.println("Actual Page Title: " + actualTitle);

        // Basic assertion to check if the title contains the expected text
        Assertions.assertTrue(actualTitle.contains(expectedTitle), "Title verification failed! Actual title is: " + actualTitle);

        // 4. Terminate the driver session
        Driver.closeDriver();

    }
}
