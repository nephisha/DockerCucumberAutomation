package steps;

import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.OrderManagementPage;
import pages.SiteManagementOrderDetailsPage;

public class OrderManagementSteps extends baseStep {

    OrderManagementPage orderManagementPage = new OrderManagementPage(driver);
    SiteManagementOrderDetailsPage siteManagementOrderDetailsPage = new SiteManagementOrderDetailsPage(driver);

    @And("^I Navigate to Order Management$")
    public void iNavigateToOrderManagement() throws Throwable {
        orderManagementPage.navigateToOrderManagement();
    }

    @When("^I enter emailAddress in Email field$")
    public void iEnterEmailAddressInEmailField() throws Throwable {
        orderManagementPage.enterEmailAddress();
    }

    @And("^I click Customer Search Button$")
    public void iClickSearchButton() throws Throwable {
        orderManagementPage.clickCustomerSearch();
    }

    @And("^I click Impersonate button in Search Results Page$")
    public void iClickImpersonateButtonInSearchResultsPage() throws Throwable {
        orderManagementPage.clickImpersonateShopper();
    }

    @Then("^I should see the new tab opened with the Customer Logged into website$")
    public void iShouldSeeTheNewTabOpenedWithTheCustomerLoggedIntoWebsite() throws Throwable {
        orderManagementPage.verifyUserImpersonated();
    }

    @Then("^I should see customer search page$")
    public void iShouldSeeCustomerSearchPage() throws Throwable {
        orderManagementPage.verifyCustomerSearchLandingPage();
    }

    @Then("^I should see the results for the email being searched$")
    public void iShouldSeeTheResultsForTheEmailBeingSearched() throws Throwable {
        orderManagementPage.verifyEmailSearchResult();
    }

    @When("^I enter Phone number in Phone Number input box$")
    public void iEnterPhoneNumberInPhoneNumberInputBox() throws Throwable {
        orderManagementPage.enterPhoneNumber();
    }

    @Then("^I should see the results for the phonenumber being searched$")
    public void iShouldSeeTheResultsForThePhonenumberBeingSearched() throws Throwable {
        orderManagementPage.verifyPhoneNumberSearchResult();
    }

    @And("^The Url on clicking on the order management should be the customer search URL$")
    public void theUrlOnClickingOnTheOrderManagementShouldBeTheCustomerSearchURL() throws Throwable {
        orderManagementPage.verifyCustomerSearchURL();
    }

    @When("^I enter Shopper ID in Shopper ID input field$")
    public void iEnterShopperIDInShopperIDInputField() throws Throwable {
        orderManagementPage.enterShopperID();
    }

    @Then("^I should see the results for the shopper id being searched$")
    public void iShouldSeeTheResultsForTheShopperIdBeingSearched() throws Throwable {
        orderManagementPage.verifyShopperIDSearchResult();
    }

    @When("^I enter Order Number in Order Number input field$")
    public void iEnterOrderNumberInOrderNumberInputField() throws Throwable {
        orderManagementPage.enterOrderNumber(testdata.readProperty("orderNumber"));
    }

    @Then("^I should see the results for the Order Number being searched$")
    public void iShouldSeeTheResultsForTheOrderNumberBeingSearched() throws Throwable {
        orderManagementPage.verifyShopperIDSearchResult();
    }

    @Then("^I should see the B(\\d+)B field in the search results$")
    public void iShouldSeeTheBBFieldInTheSearchResults(int arg0) throws Throwable {
        orderManagementPage.verifyB2BfieldsinCustomerSearchResults();
    }

    @When("^I click Reset Password Button$")
    public void iClickResetPasswordButton() throws Throwable {
        orderManagementPage.clickResetPasswordButton();
    }

    @And("^I enter New password, Confirm password and I click Set Password button$")
    public void iEnterNewPasswordConfirmPasswordAndIClickSetPasswordButton() throws Throwable {
        orderManagementPage.iEnterNewPasswordConfirmPasswordAndIClickSetPasswordButton();
    }

    @Then("^I should see the password reset confirmation message$")
    public void iShouldSeeThePasswordResetConfirmationMessage() throws Throwable {
        orderManagementPage.verifyPasswordResetSuccessMessageinSiteManagement();

    }

    @And("^I click Search Button in the bottom$")
    public void iClickSearchButtonInTheBottom() throws Throwable {
        orderManagementPage.clickSearchButtoninBottom();
    }

    @Then("^I expect to see the Order Details page$")
    public void iExpectToSeeTheOrderDetailsPage() throws Throwable {
        siteManagementOrderDetailsPage.verifyOrderDetailsPresenceinSiteMagement();
    }

    @And("^I click Add New Note Button$")
    public void iClickAddNewNoteButton() throws Throwable {
        orderManagementPage.clickAddNewNoteButton();
    }

    @Then("^I should see the Add Shopper Note Popup with Order Number prepopulated$")
    public void iShouldSeeTheAddShopperNotePopupWithOrderNumberPrepopulated() throws Throwable {
        orderManagementPage.verifyTheAddShopperNotePopupWithOrderNumberPrepopulated();
    }

    @And("^I enter Quick Entry, Primary reason, Secondary reason, Contact Type and Contact Summary$")
    public void iEnterQuickEntryPrimaryReasonSecondaryReasonContactTypeAndContactSummary() throws Throwable {
        orderManagementPage.EnterQuickEntryPrimaryReasonSecondaryReasonContactTypeAndContactSummary();
    }

    @And("^I click Save button$")
    public void iClickSaveButton() throws Throwable {
        orderManagementPage.clickSaveButton();
    }

    @And("^I should see the manual note saved$")
    public void iShouldSeeTheManualNoteSaved() throws Throwable {
        orderManagementPage.closePopup();
        orderManagementPage.clickViewNoteButton();
        orderManagementPage.verifySavedShopperNote();
    }

    @And("^I enter the new Date of birth$")
    public void iEnterTheNewDateOfBirth() throws Throwable {
        orderManagementPage.enterNewDateOfBirth("22/09/1988");
    }

    @And("^I click the Update Button$")
    public void iClickTheUpdateButton() throws Throwable {
        orderManagementPage.clickUpdateButton();
    }

    @Then("^I should see the new Date of Birth saved$")
    public void iShouldSeeTheNewDateOfBirthSaved() throws Throwable {
        orderManagementPage.verifyNewDateOfBirth("22/09/1988");
    }
}
