 @reset @regression @website @newregisterdecidelater

Feature: Sign Up Successfully By Choosing Decide Later

  Scenario: Sign Up Successfully By Choosing Decide Later

    Given I am on the Woolworths home page
    When I click on Login Profile on home page
    And I click on sign up in login page
    And I enter my firstname
    And I enter my lastname
    And I enter my email address for registration
    And I enter my password for registration
    And I enter date of birth
    And I enter preferred contact number
    And I choose "decide later" for receiving my groceries
    And I check "Email" for communication preference
    Then I click on Sign Up
    And I check if the sign up is successful
