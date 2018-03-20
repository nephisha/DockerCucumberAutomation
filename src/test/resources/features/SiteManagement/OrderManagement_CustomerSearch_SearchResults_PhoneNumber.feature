@sitemanagement @regression @reset
Feature: Verify Search results are displaying when searching by Phone NO
  Scenario: Verify Search results are displaying when searching by Phone NO

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    When I enter Phone number in Phone Number input box
    And I click Customer Search Button
    Then I should see the results for the phonenumber being searched