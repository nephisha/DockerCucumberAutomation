@sitemanagement @regression @reset

  Feature: Create a New Order Promotion in Site Management
    Scenario: Create a New Order Promotion in Site Management

      Given I am on the Woolworths Site Management Page
      And I login into SiteManagement
      When I click "Promotions" and "Order Promotions"
      And I click "Add New Order Promotion"
      And I enter Name
      And I enter Rank
      And I enter StartDate
      And I enter EndDate
      And I select EligibleShoppers as "BDDSessionGroup"
      And I enter QualifyingAmount
      And I enter target as "Subtotal"
      And I select Discount Type as Percent off
      And I enter Amount
      And I enter OfferID
      And I click Update Button
      Then I should see the Order Promotion saved
