**Capstone Project Implementation Using Selenium with Java (BDD Framework)**

**Project Overview**

This document outlines the implementation of a capstone project using Selenium with Java, following the Behavior-Driven Development (BDD) framework. The project is structured to validate the functionality of specific pages on "The Internet" demo website.

**Scenario 1: Test Implementation Using Gherkin Language**

**Test Steps**

1. Launch the URL: <http://the-internet.herokuapp.com/> and verify the page title.
2. Click on the "A/B Testing" link and verify that the displayed text is "A/B Test Variation 1" using TestNG assertions.
3. Navigate back to the homepage and click on the "Dropdown" link.
4. Select "Option1" from the dropdown and confirm if it is selected.
5. Navigate back to the homepage and click on "Frames".
6. Verify the presence of the following hyperlinks on the Frames page:
    - Nested Frames
    - iFrame

**Mandatory Implementation Concepts**

To ensure a structured approach in designing the test framework, the following concepts must be applied:

1. **Maven Project Setup**
    - Create a Maven project.
    - Update pom.xml with necessary dependencies for Selenium and BDD (Cucumber, TestNG, etc.).
2. **Version Control & Branching**
    - Create a new branch: CapstoneProject-Selenium-Java-BDD.
    - Implement the test scripts and commit the code to this branch.
    - Push the completed code to the repository.
3. **BDD Framework Implementation**
    - Create a Feature File that defines the test scenarios using Gherkin syntax.
    - Implement Step Definition Files to map Gherkin steps to Java methods.
    - Use a Runner Class to execute tests.
    - Implement TestNG.xml for test execution.
4. **Object-Oriented Programming (OOPs) Principles**
    - Maintain a Base Test Class to manage WebDriver setup and teardown.
    - Use a Base Page Class to implement reusable methods.
5. **Test Validation**
    - Use TestNG Assertions to validate expected vs. actual results.

**Project Structure**

The project is structured as follows:

**Java Classes**

- **BaseTest.java**
  - Path: D:\\CapstoneProject\\src\\test\\java\\com\\example\\base\\BaseTest.java
- **BasePage.java**
  - Path: D:\\CapstoneProject\\src\\test\\java\\com\\example\\pages\\BasePage.java
- **TestRunner.java** (BDD Test Execution Runner)
  - Path: D:\\CapstoneProject\\src\\test\\java\\com\\example\\runner\\TestRunner.java
- **Step Definitions:**
  - Path: D:\\CapstoneProject\\src\\test\\java\\com\\example\\stepDefinitions\\CapstoneProjectTests.java

**Resources & Configuration**

- **WebDriver:** D:\\CapstoneProject\\src\\test\\resources\\drivers\\chromedriver.exe
- **Feature File:** D:\\CapstoneProject\\src\\test\\resources\\features\\capstone.feature
- **TestNG Configuration File:** D:\\CapstoneProject\\testng.xml
- **Maven Configuration File:** D:\\CapstoneProject\\pom.xml

**Test Execution & Results**

Upon successful execution, the results will be generated in the following locations:

1. **TestNG Results:** D:\\CapstoneProject\\test-output
2. **Cucumber Reports:** D:\\CapstoneProject\\target\\cucumber-reports
