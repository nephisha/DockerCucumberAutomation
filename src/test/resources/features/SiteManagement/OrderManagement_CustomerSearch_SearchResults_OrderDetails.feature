@sitemanagement @regression @reset
Feature: Verify Order details are displayed correctly in Search results
  Scenario: Verify Order details are displayed correctly in Search results

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    When I enter Order Number in Order Number input field
    And I click Search Button in the bottom
    Then I expect to see the Order Details page
