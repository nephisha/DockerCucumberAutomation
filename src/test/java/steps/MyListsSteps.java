package steps;

import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.homePage;
import pages.loginPage;
import pages.mylistsPage;

public class MyListsSteps extends baseStep {

    private mylistsPage mylistsPageObject = new mylistsPage(driver);

    @Then("^I check my lists for \"([^\"]*)\" user$")
    public void iCheckMyListsForUser(String login_type) throws Throwable {
        mylistsPageObject.SavedListContainerVerify(login_type);
    }

    @And("^I click on My Woolworths Rewards List$")
    public void iClickOnMyWoolworthsRewardsList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mylistsPageObject.ClickMyWoolworthsList();
    }
}
