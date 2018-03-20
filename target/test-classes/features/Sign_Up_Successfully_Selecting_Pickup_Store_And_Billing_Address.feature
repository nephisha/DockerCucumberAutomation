 @reset @regression @website @newregisterpickup

Feature: Sign Up Successfully Selecting Pickup Store And Billing Address

  Scenario: Sign Up Successfully Selecting Pickup Store And Billing Address

    Given I am on the Woolworths home page
    When I click on "Create account" on home page
    And I enter my firstname
    And I enter my lastname
    And I enter my email address for registration
    And I enter my password for registration
    And I enter date of birth
    And I enter preferred contact number
    And I choose "Pick up" for receiving my groceries
    And I choose pick up address
    And I enter "Amas" billing address
    Then I click on Sign Up
    And I check if the sign up is successful
