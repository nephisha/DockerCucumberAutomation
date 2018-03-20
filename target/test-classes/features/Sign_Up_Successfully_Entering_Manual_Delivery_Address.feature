 @reset @regression @website @newregisterdeliverymanual

Feature: Sign Up Successfully Entering Manual Delivery Address

  Scenario: Sign Up Successfully Entering Manual Delivery Address

    Given I am on the Woolworths home page
    When I click on "Create account" on home page
    And I enter my firstname
    And I enter my lastname
    And I enter my email address for registration
    And I enter my password for registration
    And I enter date of birth
    And I enter preferred contact number
    And I choose "Delivery" for receiving my groceries
    And I enter "Manual" address for delivery
    And I check "SMS" for communication preference
    Then I click on Sign Up
    And I check if the sign up is successful
