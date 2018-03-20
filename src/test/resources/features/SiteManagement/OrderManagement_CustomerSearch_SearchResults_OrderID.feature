@sitemanagement @regression @reset
Feature: Verify Search results are displaying when searching by Order ID
  Scenario: Verify Search results are displaying when searching by Order ID

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    When I enter Order Number in Order Number input field
    And I click Customer Search Button
    Then I should see the results for the Order Number being searched