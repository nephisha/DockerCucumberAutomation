@sitemanagement @regression @reset
Feature: Verify Search results are displaying when searching by Email Address
  Scenario: Verify Search results are displaying when searching by Email Address

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    When I enter emailAddress in Email field
    And I click Customer Search Button
    Then I should see the results for the email being searched