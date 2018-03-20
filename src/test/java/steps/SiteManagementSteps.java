package steps;

import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import pages.homePage;
import pages.orderDiscountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class SiteManagementSteps extends baseStep {

    private homePage homepageObject = new homePage(driver);
    private orderDiscountPage orderDiscountPageObject = new orderDiscountPage(driver);

    @Given("^I am on the Woolworths Site Management Page$")
    public void IamOnSiteManagement() {
        homepageObject.NavigateTo(configfile.readProperty("sitemanagementUrl"));
    }


    @When("^I click \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iClickAnd(String arg0, String arg1) throws Throwable {
        orderDiscountPageObject.navigateThroughMenu(arg0,arg1);
    }


    @And("^I click \"([^\"]*)\"$")
    public void iClick(String arg0) throws Throwable {
        orderDiscountPageObject.navigateThroughMenu(arg0);
    }

    @And("^I login into SiteManagement$")
    public void iLoginIntoSiteManagement() throws Throwable {
        orderDiscountPageObject.LoginSiteManagement();
    }

    @And("^I enter Name$")
    public void iEnterName() throws Throwable {
        orderDiscountPageObject.enterName();
    }

    @And("^I enter Rank$")
    public void iEnterRank() throws Throwable {
        orderDiscountPageObject.enterRank();
    }

    @And("^I enter StartDate$")
    public void iEnterStartDate() throws Throwable {
        orderDiscountPageObject.enterStartDate();
    }

    @And("^I enter EndDate$")
    public void iEnterEndDate() throws Throwable {
        orderDiscountPageObject.enterEndDate();
    }

    @And("^I select EligibleShoppers as \"([^\"]*)\"$")
    public void iSelectEligibleShoppersAs(String arg0) throws Throwable {
        orderDiscountPageObject.selectEligibleShoppers(arg0);
    }

    @And("^I enter QualifyingAmount$")
    public void iEnterQualifyingAmount() throws Throwable {
        orderDiscountPageObject.enterQualifyingAmount();
    }

    @And("^I enter target as \"([^\"]*)\"$")
    public void iEnterTargetAsSubTotal(String arg0) throws Throwable {
        orderDiscountPageObject.enterTarget(arg0);
    }

    @And("^I select Discount Type as Percent off$")
    public void iSelectDiscountTypeAsPercentOff() throws Throwable {
        orderDiscountPageObject.selectDiscountType();
    }

    @And("^I enter Amount$")
    public void iEnterAmount() throws Throwable {
        orderDiscountPageObject.enterAmount();
    }

    @And("^I enter OfferID$")
    public void iEnterOfferID() throws Throwable {
        orderDiscountPageObject.enterOfferID();
    }

    @And("^I click Update Button$")
    public void iClickUpdateButton() throws Throwable {
        orderDiscountPageObject.clickUpdateButton();
    }

    @Then("^I should see the Order Promotion saved$")
    public void iShouldSeeTheOrderPromotionSaved() throws Throwable {
        orderDiscountPageObject.verifyIfOrderPromotionSaved();
    }


}
