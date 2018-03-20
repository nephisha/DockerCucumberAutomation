package steps;

//import com.cucumber.listener.Reporter;

//import base.baseStep;
import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.BasePage;
import pages.homePage;
import pages.loginPage;
import pages.signupPage;

import java.io.IOException;

//import sun.jvm.hotspot.debugger.Page;

public class SignUpSteps extends baseStep {

    private signupPage signupPageObject = new signupPage(driver);
    private homePage homePageObject = new homePage(driver);

    @And("^I enter my firstname$")
    public void iEnterMyFirstname() throws Throwable {
        signupPageObject.enterfirstname();
        LOGGER.info("First Name has been successfully entered");
    }


    @And("^I enter my lastname$")
    public void iEnterMyLastname() throws Throwable {
        signupPageObject.enterlastname();
        LOGGER.info("Last Name has been successfully entered");
    }

    @And("^I enter my email address for registration$")
    public void iEnterMyEmailAddressForRegistration() throws Throwable {
        signupPageObject.signup_emailaddress();
        LOGGER.info("Email Address has been successfully entered");
    }

    @And("^I enter my password for registration$")
    public void iEnterMyPasswordForRegistration() throws Throwable {
        signupPageObject.signup_password();
        LOGGER.info("Password has been successfully entered");
    }

    @And("^I enter date of birth$")
    public void iEnterDateOfBirth() throws Throwable {
        signupPageObject.date_of_birth();
        LOGGER.info("Date Of Birth has been successfully entered");
    }

    @And("^I enter preferred contact number$")
    public void iEnterPreferredContactNumber() throws Throwable {
        signupPageObject.preferred_contact_number();
        LOGGER.info("Preferred Contact Number has been successfully entered");
    }


    @Then("^I click on Sign Up$")
    public void iClickOnSignUp() throws Throwable {
        signupPageObject.sign_up();
        LOGGER.info("Clicked on Sign Up successfully");
    }

    @And("^I choose \"([^\"]*)\" for receiving my groceries$")
    public void iChooseForReceivingMyGroceries(String deliverytype) throws Throwable {
        signupPageObject.receiving_groceries(deliverytype);
        LOGGER.info("I choose " + deliverytype + " for receiving my groceries");
    }


    @And("^I choose pick up address$")
    public void iChoosePickUpAddress() throws Throwable {
        signupPageObject.choose_pickup_store();
        LOGGER.info("Pick Up Store has been selected Successfully");
    }

    @And("^I enter \"([^\"]*)\" address for delivery$")
    public void iEnterAddressForDelivery(String addtype) throws Throwable {
        signupPageObject.enter_address(addtype);
        LOGGER.info("I enter "+ addtype +" address for delivery");
    }

    @And("^I enter \"([^\"]*)\" billing address$")
    public void iEnterBillingAddress(String billtype) throws Throwable {
        signupPageObject.enter_billing_address(billtype);
        LOGGER.info("I enter "+ billtype +" address for billing");
    }




    @And("^I should see error message for first name \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForFirstName(String fname_err_msg) throws Throwable {
        signupPageObject.errormsg_firstname(fname_err_msg);
    }


    @And("^I should see error message for last name \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForLastName(String lname_err_msg) throws Throwable {
        signupPageObject.errormsg_lastname(lname_err_msg);
    }

    @And("^I should see error message for email address \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForEmailAddress(String emailaddr_err_msg) throws Throwable {
       signupPageObject.errormsg_emailaddress(emailaddr_err_msg);
    }

    @And("^I should see error message for password \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForPassword(String pwd_err_msg) throws Throwable {
       signupPageObject.errormsg_password(pwd_err_msg);
    }

    @And("^I should see error message for preferred contact number \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForPreferredContactNumber(String contno_err_msg) throws Throwable {
        signupPageObject.errormsg_contnumber(contno_err_msg);
    }

    @And("^I should see error message for delivery address \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageForDeliveryAddress(String addr_err_msg) throws Throwable {
        signupPageObject.errormsg_address(addr_err_msg);
    }

    @And("^I should see the valid message \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iShouldSeeTheValidMessageAnd(String arg0, String arg1) throws Throwable {
        signupPageObject.valdation_msg(arg0,arg1);
    }

    @And("^I enter ABN details$")
    public void iEnterABNDetails() throws Throwable {
        signupPageObject.abn_details();
        LOGGER.info("ABD Details have been entered successfully");
    }

    @And("^I check if the sign up is successful$")
    public void iCheckIfTheSignUpIsSuccessful() throws Throwable {
        homePageObject.wow_tab_wrapper_present();
        LOGGER.info("Sign up / Registration is successful");
    }

    @And("^I enter woolworths rewards card number and password$")
    public void iEnterWoolworthsRewardsCardNumberAndPassword() throws Throwable {
        signupPageObject.rewardscarddetails();
        LOGGER.info("Woolworths Reward Card Number and Password Entered Successfully");
    }

    @And("^I check \"([^\"]*)\" for communication preference$")
    public void iCheckForCommunicationPreference(String comm_pref) throws Throwable {
        signupPageObject.communication_pref(comm_pref);
        LOGGER.info("Communication Preference " + comm_pref + " has been checked successfully");
    }

    @And("^I click on Sign up with Paypal$")
    public void iClickOnSignUpWithPaypal() throws Throwable {
        signupPageObject.clickonPayPal();
        LOGGER.info("Clicked on Sign up with PayPal successfully");
    }
}
