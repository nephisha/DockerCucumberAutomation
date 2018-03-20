package steps;

import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.cataloguePage;
import pages.mylistsPage;

public class CatalogueSteps extends baseStep {

    private cataloguePage cataloguePageObject = new cataloguePage(driver);

    @And("^I enter postcode for searching the catalogue$")
    public void iEnterPostcodeForSearchingTheCatalogue() throws Throwable {
        cataloguePageObject.EnterPostCode();
    }

    @And("^I select the store from the available list$")
    public void iSelectTheStoreFromTheAvailableList() throws Throwable {
        cataloguePageObject.StoreSelection();
    }

    @And("^I verify if the catalogue is displaying$")
    public void iVerifyIfTheCatalogueIsDisplaying() throws Throwable {
        cataloguePageObject.VerifyCatalogueDisplay();
    }

    @Then("^I click on one of the catalogue$")
    public void iClickOnOneOfTheCatalogue() throws Throwable {
        cataloguePageObject.CatalogueClickVerify();
    }
}
