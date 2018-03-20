 @reset @regression @website @placeordernewuserpp

Feature: New Registration and Placing Order on Woolworths site using Paypal

  Scenario: New Registration and Placing Order on Woolworths site using Paypal

    Given I am on the Woolworths home page
    When I click on "Create account" on home page
    And I enter my firstname
    And I enter my lastname
    And I enter my email address for registration
    And I enter my password for registration
    And I enter date of birth
    And I enter preferred contact number
    And I choose "decide later" for receiving my groceries
    Then I click on Sign Up
    And I check if the sign up is successful
    And I empty the cart if items are already added to the cart
    And I choose delivery option "Delivery"
    And I enter/choose "Amas" delivery address
    And I choose delivery date
    And I choose delivery time
    And I search for "Dairy,Eggs & Fridge" stockcode
    And I add one item to the trolley
    And I open or close the cart
    And I increase the items count
    And I search for "Pantry" stockcode
    And I add one item to the trolley
    And I increase the items count
    And I search for "Freezer" stockcode
    And I add one item to the trolley
    And I increase the items count
    And I click on Checkout button
    And I click on Continue to checkout in HYF Page
    And I click on confirm in delivery confirmed window on checkout page
    And I check if Earn and Learn dialog is available
    And I click on confirm in review order page on checkout page
    And I select payment type "PayPal"
    And I enter my paypal details
    Then I click on Place Order
    And I capture the order number


