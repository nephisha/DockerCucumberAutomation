@sitemanagement @regression @reset
Feature: Verify that user is able to add notes manually
  Scenario: Verify that user is able to add notes manually

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    When I enter emailAddress in Email field
    And I click Customer Search Button
    And I click Add New Note Button
    Then I should see the Add Shopper Note Popup with Order Number prepopulated
    And I enter Quick Entry, Primary reason, Secondary reason, Contact Type and Contact Summary
    And I click Save button
    And I should see the manual note saved