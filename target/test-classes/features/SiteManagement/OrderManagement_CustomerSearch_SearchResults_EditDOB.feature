@sitemanagement @regression @reset @test
Feature: Verify that DOB field is able to edit
  Scenario: Verify that DOB field is able to edit

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    When I enter emailAddress in Email field
    And I click Customer Search Button
    And I should see the results for the email being searched
    And I enter the new Date of birth
    And I click the Update Button
    Then I should see the new Date of Birth saved
