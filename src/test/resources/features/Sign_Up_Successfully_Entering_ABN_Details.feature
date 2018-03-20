 @reset @regression @website @newregisterbusdecidelater

Feature: Sign Up Successfully Entering ABN Details

  Scenario: Sign Up Successfully Entering ABN Details

    Given I am on the Woolworths home page
    When I click on "Create account" on home page
    And I enter my firstname
    And I enter my lastname
    And I enter my email address for registration
    And I enter my password for registration
    And I enter date of birth
    And I enter preferred contact number
    And I enter ABN details
    And I choose "decide later" for receiving my groceries
    Then I click on Sign Up
    And I check if the sign up is successful
