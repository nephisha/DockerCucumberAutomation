Feature: MyList

  Scenario:
    Given I am on the Woolworths home page
    When I click on "Login" on home page
    And I provide username and password for "Woolworths Rewards"
    And I select remember me option
    And I click on login button on the login page
    When I click on "My Lists" header link
    And I click on My Woolworths Rewards List
    #Then I should see the List of products purchased using my rewards card