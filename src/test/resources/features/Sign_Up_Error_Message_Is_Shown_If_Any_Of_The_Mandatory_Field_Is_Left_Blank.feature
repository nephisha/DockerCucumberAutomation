 @reset @regression @website @errormessagessignup

Feature: Sign Up Verify That Error Message Is Shown If Any Of The Mandatory Field Is Left Blank

  Scenario: Sign Up Verify That Error Message Is Shown If Any Of The Mandatory Field Is Left Blank

    Given I am on the Woolworths home page
    When I click on Login Profile on home page
    And I click on sign up in login page
    Then I click on Sign Up
    And I should see the valid message "The sign up was not successful." and "There are 6 field(s) that require your attention."
    And I should see error message for first name "First name is required."
    And I should see error message for last name "Last name is required."
    And I should see error message for email address "Email address is required."
    And I should see error message for password "Password is required."
    And I should see error message for preferred contact number "Phone number is required."
    And I should see error message for delivery address "Address is required."



