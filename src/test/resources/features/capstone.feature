Feature: Capstone Project

  Scenario: Verify Page Title and A/B Test Variation 1 Text
    Given User navigates to "http://the-internet.herokuapp.com/"
    Then Verify the page title is "The Internet"
    When User clicks on "A/B Testing" link
    Then Verify the text on the page is "A/B Test Variation 1|A/B Test Control"
    When User navigates back to Home page
    And User clicks on "Dropdown" link
    Then Select "Option 1" from dropdown
    And Confirm it is selected
    When User navigates back to Home page
    And User clicks on "Frames" link
    Then Verify hyperlinks "Nested Frames" and "iFrame" are present
