package com.example.stepDefinitions;

import com.example.base.BaseTest;
import com.example.pages.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CapstoneProjectTests extends BaseTest {
    private BasePage page;

    @Before
    public void initPage() {
        setUp(); // Ensure this method is called to initialize the WebDriver
        page = new BasePage(driver);
    }

    @After
    public void tearDownScenario() {
        if (driver != null) {
            driver.quit();
            logResult("Browser closed after scenario", true);
            driver = null;
        }
    }

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        page.navigateTo(url);
    }

    @Then("Verify the page title is {string}")
    public void verify_the_page_title_is(String title) {
        page.verifyPageTitle(title);
    }

    @When("User clicks on {string} link")
    public void user_clicks_on_link(String linkText) {
        page.click(By.linkText(linkText));
    }

    @Then("Verify the text on the page is {string}")
    public void verify_the_text_on_the_page_is(String expectedTexts) {
        String[] expectedTextArray = expectedTexts.split("\\|");
        for (String expectedText : expectedTextArray) {
            try {
                page.verifyTextPresent(expectedText);
                return;
            } catch (AssertionError ignored) {
            }
        }
        throw new AssertionError("None of the expected texts were found!");
    }

    @When("User navigates back to Home page")
    public void user_navigates_back_to_home_page() {
        driver.navigate().back();
        logResult("Navigated back to Home page", true);
    }

    @Then("Select {string} from dropdown")
    public void select_from_dropdown(String option) {
        page.selectFromDropdown(By.id("dropdown"), option);
    }

    @Then("Confirm it is selected")
    public void confirm_it_is_selected() {
        boolean isSelected = driver.findElement(By.cssSelector("#dropdown option:checked")).isSelected();
        logResult("Dropdown option selected: " + isSelected, isSelected);
        Assert.assertTrue(isSelected, "Dropdown option is not selected!");
    }

    @Then("Verify hyperlinks {string} and {string} are present")
    public void verify_hyperlinks_are_present(String linkText1, String linkText2) {
        boolean link1Present = driver.findElement(By.linkText(linkText1)).isDisplayed();
        boolean link2Present = driver.findElement(By.linkText(linkText2)).isDisplayed();
        logResult("Hyperlink '" + linkText1 + "' present: " + link1Present, link1Present);
        logResult("Hyperlink '" + linkText2 + "' present: " + link2Present, link2Present);
        Assert.assertTrue(link1Present, "Hyperlink '" + linkText1 + "' is missing!");
        Assert.assertTrue(link2Present, "Hyperlink '" + linkText2 + "' is missing!");
    }
}
