@sitemanagement @regression @reset
Feature: Verify that the Order Management landing page redirect to Customer search
  Scenario: Verify that the Order Management landing page redirect to Customer search

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    When I Navigate to Order Management
    Then I should see customer search page
    And The Url on clicking on the order management should be the customer search URL
