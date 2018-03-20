@reset @regression @website @passwordreset

Feature: User Able To Successfully Reset Password

  Scenario: User Able To Successfully Reset Password

    Given I am on the Woolworths home page
    When I click on "Login" on home page
    And I click on forgotten your password
    And I perform password reset
