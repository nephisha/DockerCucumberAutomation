 @reset @regression @website @mylistsloggedinuser

Feature: Verify MyLists Page For Logged In User

  Scenario: Verify MyLists Page For Logged In User

    Given I am on the Woolworths home page
    When I click on "Login" on home page
    And I provide username and password for "PayPal"
    And I click on login button on the login page
    And I click on "My Lists" header link
    Then I check my lists for "Logged In" user
