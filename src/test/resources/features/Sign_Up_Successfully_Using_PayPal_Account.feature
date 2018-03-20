 @reset @regression @website @newuserregistrationpp

Feature: Sign Up Successfully Using PayPal Account

  Scenario: Sign Up Successfully Using PayPal Account

    Given I am on the Woolworths home page
    When I click on "Create account" on home page
    And I click on Sign up with Paypal
    And I enter my paypal details
    And I enter my password for registration
    And I enter preferred contact number
    Then I click on Sign Up
    And I should see error message for email address "The entered email already exists"
#    And I check if the sign up is successful

