@sitemanagement @regression @reset
Feature: CSR can impersonate the shopper without any issues
  Scenario: CSR can impersonate the shopper without any issues

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    When I enter emailAddress in Email field
    And I click Customer Search Button
    And I click Impersonate button in Search Results Page
    Then I should see the new tab opened with the Customer Logged into website