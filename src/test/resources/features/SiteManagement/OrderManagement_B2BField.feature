@sitemanagement @regression @reset
Feature: Verify that New B2B fields are added in Customer search screen as per the Requirement
  Scenario: Verify that New B2B fields are added in Customer search screen as per the Requirement

    Given I am on the Woolworths Site Management Page
    When I login into SiteManagement
    And I Navigate to Order Management
    And I enter emailAddress in Email field
    And I click Customer Search Button
    Then I should see the B2B field in the search results