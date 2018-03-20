@sitemanagement @regression @reset
Feature: Verify that user is able to reset the password using reset password button
  Scenario: Verify that user is able to reset the password using reset password button

    Given I am on the Woolworths Site Management Page
    And I login into SiteManagement
    And I Navigate to Order Management
    And I enter emailAddress in Email field
    And I click Customer Search Button
    When I click Reset Password Button
    And I enter New password, Confirm password and I click Set Password button
    Then I should see the password reset confirmation message

