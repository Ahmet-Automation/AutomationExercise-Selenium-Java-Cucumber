package com.ahmett.stepdefinitions;

import com.ahmett.utils.Driver;
import org.junit.After;
import org.junit.Before;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
