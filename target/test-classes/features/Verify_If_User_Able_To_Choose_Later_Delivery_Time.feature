 @reset @regression @website @chooselaterdeliverytime

Feature: Verify If User Able To Choose Later Delivery Time

  Scenario: Verify If User Able To Choose Later Delivery Time
    Given I am on the Woolworths home page
    When I click on "Login" on home page
    And I provide username and password for "Cybersource Payment"
    And I click on login button on the login page
    And I empty the cart if items are already added to the cart
    And I choose delivery option "Delivery"
    And I enter/choose "Amas" delivery address
    And I choose delivery date
    And I choose a time later