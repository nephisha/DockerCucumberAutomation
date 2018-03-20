 @reset @regression @website @restrictedliquoritem

Feature: Place Delivery Order Restricted Items ErrMessage Using Credit Card - Cybersource

  Scenario: Place Delivery Order Restricted Items ErrMessage Using Credit Card - Cybersource

    Given I am on the Woolworths home page
    When I click on "Login" on home page
    And I provide username and password for "Cybersource1 Payment"
    And I click on login button on the login page
    And I empty the cart if items are already added to the cart
    And I choose delivery option "Delivery"
    And I enter/choose "Amas" delivery address
    And I choose delivery date
    And I choose delivery time
    And I search for "Liquor" stockcode
    And I add one item to the trolley
    And I check for restricted dialog box
    And I open or close the cart
    And I increase the items count
    And I search for "Meat,Seafood & Deli" stockcode
    And I add one item to the trolley
    And I increase the items count
    And I click on Checkout button
    And I click on Continue to checkout in HYF Page
    And I click on confirm in delivery confirmed window on checkout page
#    And I check if Earn and Learn dialog is available
    And I check if the restriction warning message for delivery is shown
    And I click on confirm in review order page on checkout page
    And I select payment type "credit card"
    And I enter my credit card details
#    Then I click on Place Order
    And I capture the order number



