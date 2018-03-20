 @reset @regression @website @chooselaterccwebpay

Feature: Place Choose Later Order from Woolworths Online Using Credit Card - WebCybersourcepay Payment Method

  Scenario: Place Choose Later Order from Woolworths Online Using Credit Card - Cybersource Payment Method

    Given I am on the Woolworths home page
    When I click on "Login" on home page
    And I provide username and password for "Cybersource2 Payment"
    And I click on login button on the login page
    And I empty the cart if items are already added to the cart
    And I choose delivery option "Choose later"
#    And I enter "Amas" address for billing
    And I search for "Household" stockcode
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
    And I choose delivery option "Delivery"
    And I enter/choose "Amas" delivery address
    And I choose delivery date
    And I choose delivery time
    And I click on confirm in delivery confirmed window on checkout page
#    And I check if Earn and Learn dialog is available
    And I click on confirm in review order page on checkout page
    And I select payment type "credit card"
    And I enter my credit card details
#    Then I click on Place Order
    And I capture the order number




