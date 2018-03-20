 @reset @regression @website @newregisterdeliveryamasedr

Feature: Sign Up Successfully Entering EDR Card Details And AMAS Address

  Scenario: Sign Up Successfully Entering EDR Card Details And AMAS Address

    Given I am on the Woolworths home page
    When I click on "Create account" on home page
    And I enter my firstname
    And I enter my lastname
    And I enter my email address for registration
    And I enter my password for registration
    And I enter date of birth
    And I enter preferred contact number
    And I enter woolworths rewards card number and password
    And I choose "Delivery" for receiving my groceries
    And I enter "Amas" address for delivery
    Then I click on Sign Up
    And I check if the sign up is successful
