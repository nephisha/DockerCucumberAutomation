@reset @regression @website @corporateheaderlinks

Feature: Homepage Header Menu Verify Links

  Scenario: Homepage Header Menu Verify Links
    Given I am on the Woolworths home page
    When I check for corporate header link "Shopping"
     And I check for corporate header link "Stores"
     And I check for corporate header link "Insurance"
     And I check for corporate header link "Mobile"
     And I check for corporate header link "Credit Cards"
     And I check for corporate header link "Rewards"
     Then I check for corporate header link "Gift Cards"







