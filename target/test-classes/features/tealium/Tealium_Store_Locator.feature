@component:ui
@product:wowonline
@tealium
@reset
@regression
Feature: WowOnline website Tealium tags
  In order for provide better csutomer service
  As a woolworths IT support for wow online website
  I want to see analytics of customer usage

  @tealium
  Scenario: Tealium tags on wow online home page
    Given I am on the Woolworths home page
    When I click on Login on home page
    And I provide email username and password
    And I click on login button on the login page

#    Given I am on the Woolworths home page
    And I see wowonline website home

    And I navigate to store locator
    Then I should see tealium tag : site.Section with value : shop:locator
    And I should see tealium tag : cart.TotalValue with value : 0