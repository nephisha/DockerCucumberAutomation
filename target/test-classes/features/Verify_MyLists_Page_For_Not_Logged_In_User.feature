 @reset @regression @website @mylistsnotloggedinuser

Feature: Verify MyLists Page For Not Logged In User

  Scenario: Verify MyLists Page For Not Logged In User

    Given I am on the Woolworths home page
    When I click on "My Lists" header link
    Then I check my lists for "Not Logged In" user
