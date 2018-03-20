package steps;

import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.*;
//import base.baseStep;
import support.PropertyReader;

public class PlaceOrderSteps extends baseStep {

    private globalPage globalpageobject = new globalPage(driver);
    private productPage productpageobject = new productPage(driver);
    private cartPage cartpageobject = new cartPage(driver);
    private checkoutPage checkpageobject = new checkoutPage(driver);
    private haveyouforgottenPage haveyouforgottenpageobject = new haveyouforgottenPage(driver);
    private orderconfirmationPage orderconfirmationageobject = new orderconfirmationPage(driver);


    @And("^I empty the cart if items are already added to the cart$")
    public void iEmptyTheCartIfItemsAreAlreadyAddedToTheCart() throws Throwable {
        productpageobject.openclosecart();
        cartpageobject.RemoveAllProducts();
    }

    @And("^I search for \"([^\"]*)\" stockcode$")
    public void iSearchForStockcode(String searchitem) throws Throwable {
        globalpageobject.SearchItem(searchitem);
        productpageobject.producttoload();
    }

    @And("^I add one item to the trolley$")
    public void iAddOneItemToTheTrolley() throws Throwable {
        productpageobject.addtocart();
    }

    @And("^I choose delivery option \"([^\"]*)\"$")
    public void iChooseDeliveryOption(String deliverytype) throws Throwable {
        cartpageobject.ChooseDeliveryMethod(deliverytype);
    }

    @And("^I choose delivery date$")
    public void iChooseDeliveryDate() throws Throwable {
        cartpageobject.dateselection();
    }

    @And("^I click on Checkout button$")
    public void iClickOnCheckoutButton() throws Throwable {
        cartpageobject.ClickonCheckout();
    }

    @And("^I click on Continue to checkout in HYF Page$")
    public void iClickOnContinueToCheckoutInHYFPage() throws Throwable {
        haveyouforgottenpageobject.ContinueHYF();
    }

    @And("^I click on confirm in delivery confirmed window on checkout page$")
    public void iClickOnConfirmInDeliveryConfirmedWindowOnCheckoutPage() throws Throwable {
        checkpageobject.DeliveryInstructionsLoad();
        checkpageobject.ClickConfirm();
    }

    @And("^I click on confirm in review order page on checkout page$")
    public void iClickOnConfirmInReviewOrderPageOnCheckoutPage() throws Throwable {
        checkpageobject.ClickConfirm();
    }

    @And("^I select payment type \"([^\"]*)\"$")
    public void iSelectPaymentType(String payment_type) throws Throwable {
        checkpageobject.SelectPaymentType(payment_type);
    }

    @And("^I enter my credit card details$")
    public void iEnterMyCreditCardDetails() throws Throwable {
        checkpageobject.entercarddetails();
    }

    @And("^I enter my paypal details$")
    public void iEnterMyPaypalDetails() throws Throwable {
        checkpageobject.paypaldetails();
    }

    @Then("^I click on Place Order$")
    public void iClickOnPlaceOrder() throws Throwable {
        checkpageobject.PlaceOrder();
    }

    @And("^I capture the order number$")
    public void iCaptureTheOrderNumber() throws Throwable {
        orderconfirmationageobject.ordercapture();
    }

    @And("^I check if Earn and Learn dialog is available$")
    public void iCheckIfEarnAndLearnDialogIsAvailable() throws Throwable {
        checkpageobject.earn_learn();
    }

    @And("^I choose delivery time$")
    public void iChooseDeliveryTime() throws Throwable {
        cartpageobject.timeselection();
    }

    @And("^I choose a time later$")
    public void iChooseATimeLater() throws Throwable {
        cartpageobject.IChooseATimeLater();
    }

    @And("^I open or close the cart$")
    public void iOpenOrCloseTheCart() throws Throwable {
        productpageobject.openclosecart();
    }

    @And("^I increase the items count$")
    public void iIncreaseTheItemsCount() throws Throwable {
        productpageobject.increaseitemcount();
    }

    @And("^I check for restricted dialog box$")
    public void iCheckForRestrictedDialogBox() throws Throwable {
        cartpageobject.restricteddialogbox();
    }

    @And("^I check if the restriction warning message for delivery is shown$")
    public void iCheckIfTheRestrictionWarningMessageForDeliveryIsShown() throws Throwable {
        cartpageobject.RestrictionWarningDelivery();
    }

    @And("^I click to change the billing address$")
    public void iClickToChangeTheBillingAddress() throws Throwable {
        cartpageobject.ClickChangeBillingAddress();
    }

    @And("^I enter/choose \"([^\"]*)\" delivery address$")
    public void iEnterChooseDeliveryAddress(String deliveryaddrtype) throws Throwable {
        cartpageobject.DeliveryAddress(deliveryaddrtype);
    }
}
