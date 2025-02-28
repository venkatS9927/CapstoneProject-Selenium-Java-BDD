package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.example.base.BaseTest.logResult;

public class HomePage extends BasePage {

    @SuppressWarnings("unused") // Suppresses IDE warning for "never assigned" fields
    @FindBy(linkText = "A/B Testing")
    private WebElement abTestingLink;

    @SuppressWarnings("unused")
    @FindBy(linkText = "Dropdown")
    private WebElement dropdownLink;

    @SuppressWarnings("unused")
    @FindBy(linkText = "Frames")
    private WebElement framesLink;

    @SuppressWarnings("unused")
    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFramesLink;

    @SuppressWarnings("unused")
    @FindBy(linkText = "iFrame")
    private WebElement iFrameLink;

    @SuppressWarnings("unused")
    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Properly initializes PageFactory elements
    }

    public void clickLink(String linkText) {
        WebElement link = getLinkElement(linkText);
        if (link != null) {
            link.click();
            logResult("Clicked on link: " + linkText, true);
        } else {
            logResult("Failed to find link: " + linkText, false);
            Assert.fail("Failed to find link: " + linkText);
        }
    }

    public void verifyTextPresent(String expectedText) {
        String actualText = driver.findElement(By.tagName("body")).getText().trim();
        logResult("Verifying text. Expected: " + expectedText + ", Actual: " + actualText, actualText.contains(expectedText));
        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found!");
    }

    public void selectFromDropdown(String option) {
        dropdown.click();
        dropdown.findElement(By.xpath("//option[. = '" + option + "']")).click();
        logResult("Selected option: " + option + " from dropdown", true);
    }

    public void confirmDropdownSelection(String expectedOption) {
        String selectedOption = dropdown.findElement(By.cssSelector("option:checked")).getText();
        boolean isSelected = selectedOption.equals(expectedOption);
        logResult("Dropdown selection verified. Expected: " + expectedOption + ", Actual: " + selectedOption, isSelected);
        Assert.assertTrue(isSelected, "Dropdown option is not selected correctly!");
    }

    private WebElement getLinkElement(String linkText) {
        switch (linkText) {
            case "A/B Testing":
                return abTestingLink;
            case "Dropdown":
                return dropdownLink;
            case "Frames":
                return framesLink;
            case "Nested Frames":
                return nestedFramesLink;
            case "iFrame":
                return iFrameLink;
            default:
                return null;
        }
    }
}
