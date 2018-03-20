package steps;

import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;

import support.PropertyReader;

import java.io.IOException;

public class HomeSteps extends baseStep {

    private homePage homepageObject = new homePage(driver);
    private loginPage loginPageObject = new loginPage(driver);

    @Given("^I am on the Woolworths home page")
    public void IAmOnhomePage() throws IOException {
        homepageObject.NavigateTo(configfile.readProperty("url_base")); //uatsite.woolworths.com.au //www.woolworths.com.au
//        Reporter.addScreenCaptureFromPath(capture(getScenario(),"I am on the woolworths homepage"));
//        takescreenshot();
//        eTest.pass("", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
//        Reporter.addScreenCaptureFromPath(capture());
//        take_screenshot(this.scenario);

    }


    @When("^I see wowonline website home$")
    public void verify_wowonline_home_page() throws Throwable {
        Assert.assertTrue(homepageObject.isWowOnineLoaded());
    }

    @And("^I navigate to store locator$")
    public void navigate_to_store_locator() throws Throwable {
        homepageObject.clickOnStoreLocator();

    }

    @When("^I click on Create Account on home page$")
    public void iClickOnCreateAccountOnHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on \"([^\"]*)\" on home page$")
    public void iClickOnOnHomePage(String arg1) throws Throwable {
        homepageObject.ClickLoginOnHomepage(arg1);
        Assert.assertTrue("Failed navigating to login page", loginPageObject.IsPageLoaded());
    }

    @When("^I check for corporate header link \"([^\"]*)\"$")
    public void iCheckForCorporateHeaderLink(String corpheaderlinks) throws Throwable {
        homepageObject.CorporateHeaderLinks(corpheaderlinks);
        LOGGER.info("All the Corporate Headers Links have been verified successfully");
    }

    @When("^I click on \"([^\"]*)\" header link$")
    public void iClickOnHeaderLink(String coreheaderlink) throws Throwable {
        homepageObject.CoreHeaderLinks(coreheaderlink);
        LOGGER.info("Core Header Link " + coreheaderlink + " has been clicked successfully");
    }

    @When("^I click the trolley icon on top right corner of the screen$")
    public void iClickTheTrolleyIconOnTopRightCornerOfTheScreen() throws Throwable {
        homepageObject.TrolleyClick();
        LOGGER.info("Trolley Icon is clicked successfully");
    }

    @Then("^I check if the cart is open successfully$")
    public void iCheckIfTheCartIsOpenSuccessfully() throws Throwable {
        homepageObject.TrolleyOpenCart();
        LOGGER.info("Trolley Icon is present and click to expand the cart successfully");
    }

    @When("^I click on \"([^\"]*)\" link on department header menu$")
    public void iClickOnLinkOnDepartmentHeaderMenu(String headerlink) throws Throwable {
        homepageObject.DepartmentHeaderLinks(headerlink);
        LOGGER.info("Successfully Clicked on Header Link " + headerlink);
    }

    @When("^I click on Login Profile on home page$")
    public void iClickOnLoginProfileOnHomePage() throws Throwable {
        homepageObject.loginprofile();
        LOGGER.info("Clicked on Login Profile Icon");
    }

}
