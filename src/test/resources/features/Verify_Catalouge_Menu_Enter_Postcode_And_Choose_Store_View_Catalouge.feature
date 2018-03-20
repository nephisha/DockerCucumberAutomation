 @reset @regression @website @catalougeverify

Feature: Verify Catalouge Menu Enter Postcode And Choose Store View Catalouge

  Scenario: Verify Catalouge Menu Enter Postcode And Choose Store View Catalouge

    Given I am on the Woolworths home page
    When I click on "Catalogue" header link
    And I enter postcode for searching the catalogue
    And I select the store from the available list
    And I verify if the catalogue is displaying
    Then I click on one of the catalogue
