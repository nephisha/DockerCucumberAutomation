@reset @regression @website @login

Feature: Successful Login By Entering Valid Username And Password

  Scenario: Successful Login By Entering Valid Username And Password

    Given I am on the Woolworths home page
    When I click on "Login" on home page
    And I provide username and password for "Cybersource Payment"
    And I select remember me option
    And I click on login button on the login page

