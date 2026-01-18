package com.ahmett.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com.ahmett.stepdefinitions",
        dryRun = false,
        tags = "@Quantity"
)

public class TestRunner {
}
