package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.example.base.BaseTest.logResult;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        logResult("Element found: " + locator.toString(), true);
        return element;
    }

    public void navigateTo(String url) {
        driver.get(url);
        logResult("Navigated to URL: " + url, true);
    }

    public void click(By locator) {
        findElement(locator).click();
        logResult("Clicked on element: " + locator.toString(), true);
    }

    public void verifyTextPresent(String expectedText) {
        String actualText = driver.findElement(By.tagName("body")).getText().trim();
        logResult("Verifying text. Expected: " + expectedText + ", Actual: " + actualText, actualText.contains(expectedText));
        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found!");
    }

    public void selectFromDropdown(By dropdownLocator, String option) {
        WebElement dropdown = findElement(dropdownLocator);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[. = '" + option + "']")).click();
        logResult("Selected option: " + option + " from dropdown: " + dropdownLocator.toString(), true);
    }

    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        logResult("Verifying page title. Expected: " + expectedTitle + ", Actual: " + actualTitle, actualTitle.equals(expectedTitle));
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
    }
}
