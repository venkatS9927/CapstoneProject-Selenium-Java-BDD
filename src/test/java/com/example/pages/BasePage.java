package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static com.example.base.BaseTest.logResult;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    public void navigateTo(String url) {
        driver.get(url);
        logResult("Navigated to URL: " + url, true);
    }

    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        logResult("Verifying page title. Expected: " + expectedTitle + ", Actual: " + actualTitle, actualTitle.equals(expectedTitle));
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
    }
}
