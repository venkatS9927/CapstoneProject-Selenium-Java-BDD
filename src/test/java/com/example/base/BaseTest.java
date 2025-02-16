package com.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        try {
            String driverPath= System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logResult("Browser launched successfully", true);
            Assert.assertNotNull(driver, "Driver should be initialized");
        } catch (Exception e) {
            logResult("Failed to launch browser: " + e.getMessage(), false);
            throw e;
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            try {
                logResult("Closing browser", true);
                driver.quit();
                logResult("Browser closed successfully", true);
                driver = null; // Set driver to null after quit
            } catch (Exception e) {
                logResult("Failed to close browser: " + e.getMessage(), false);
                Assert.fail("Failed to close browser: " + e.getMessage());
            }
        } else {
            logResult("Driver was null, skipping browser close", false);
            Assert.fail("Driver was null, skipping browser close");
        }
    }

    public static void logResult(String message, boolean isPassed) {
        String color = isPassed ? "green" : "red";
        String status = "<b><span style='color:" + color + ";'>" + (isPassed ? "✅ Passed" : "❌ Failed") + "</span></b>";
        Reporter.log(message + " || " + status, true);
    }
}
