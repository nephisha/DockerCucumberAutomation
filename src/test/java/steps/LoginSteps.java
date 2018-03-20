package steps;

//import com.cucumber.listener.Reporter;
import base.baseStep;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.ScenarioOutlineRunner;
import org.junit.Assert;
import pages.BasePage;
import pages.homePage;
import pages.loginPage;
//import base.baseStep;
import support.PropertyReader;
//import sun.jvm.hotspot.debugger.Page;

import java.io.IOException;

public class LoginSteps extends baseStep {

    private homePage homePageObject = new homePage(driver);
    private loginPage loginPageObject = new loginPage(driver);


    @When("^I click on login button on the login page")
    public void WhenIClickOnTheLogin() throws IOException {
//        Reporter.addScreenCaptureFromPath(capture());
        loginPageObject.ClickLoginOnLoginPage();
        homePageObject.wow_tab_wrapper_present();
    }


    @Then("^I should see the error message (.*)")
    public void ThenIShouldSeeTheErrorMessage(String errorMessage) throws IOException {
        Assert.assertEquals("Failed to validate the error message", errorMessage, loginPageObject.GetValidationMessageForInvalidUserLogin());
    }

    @Then("^I should see mandatory fields error messages")
    public void ThenIShouldSeeMandatoryFieldsErrorMessages() throws IOException {
//        Reporter.addScreenCaptureFromPath(capture(getScenario(),"I should see mandatory fields error messages"));
//        Reporter.addScreenCaptureFromPath(capture());
        Assert.assertEquals("Failed to validate the error message", "The login was not successful.", loginPageObject.GetValidationSummaryUserMessage());
        Assert.assertEquals("Failed to validate the error message", "There are 2 field(s) that require your attention.", loginPageObject.GetValidationSummaryErrorMessage());
//        Assert.assertEquals("Failed to validate the email error message", "Email address is required.", loginPageObject.GetMandatoryOrFormatMailErrorMessage());
//        Assert.assertEquals("Failed to validate the password error message", "Password is required.", loginPageObject.GetMandatoryPasswordErrorMessage());
    }

//    @When("^I provide valid email: (.*) and password : (.*)")
//    public void WhenIProvideValidEmailAndPassword(String email, String password) throws IOException {
////        Reporter.addScreenCaptureFromPath(capture(getScenario(),"I provide valid email_" + email + " and password_" + password));
//        loginPageObject.EnterEmail(email);
//        loginPageObject.EnterPassword(password);
//    }



//    @When("^I provide username and password")
//    public void WhenIProvideUsernameAndPassword() throws IOException {
////        Reporter.addScreenCaptureFromPath(capture(getScenario(),"I provide valid email_" + email + " and password_" + password));
//        loginPageObject.EnterEmail(testdata.readProperty("username"));
//        loginPageObject.EnterPassword(testdata.readProperty("password"));
//    }

    @Then("^I should see the error messages and validation summary is hidden")
    public void IShouldSeeErrorAndValidationSummaryHidde() throws IOException {
//        Reporter.addScreenCaptureFromPath(capture(getScenario(),"I should see the error messages and validation summary is hidden "));
        Assert.assertEquals("Failed to validate the error message", null, loginPageObject.GetValidationSummaryUserMessage());
        Assert.assertEquals("Failed to validate the error message", null, loginPageObject.GetValidationSummaryErrorMessage());
//        Assert.assertEquals("Failed to validate the email error message", null, loginPageObject.GetMandatoryOrFormatMailErrorMessage());
//        Assert.assertEquals("Failed to validate the password error message", null, loginPageObject.GetMandatoryPasswordErrorMessage());
    }

    @And("^I provide username and password for \"([^\"]*)\"$")
    public void iProvideUsernameAndPasswordFor(String login_type) throws Throwable {
        loginPageObject.EnterEmail(login_type);
        loginPageObject.EnterPassword(login_type);
    }


    @And("^I click on sign up in login page$")
    public void iClickOnSignUpInLoginPage() throws Throwable {
        loginPageObject.SignUpLink();
        LOGGER.info("CLicked on Sign Up Link");
    }

    @And("^I click on forgotten your password$")
    public void iClickOnForgottenYourPassword() throws Throwable {
        loginPageObject.ForgotPassword();
        LOGGER.info("I click on Forgotten Your Password");
    }

    @And("^I perform password reset$")
    public void iPerformPasswordReset() throws Throwable {
        loginPageObject.PasswordReset();
        LOGGER.info("Password reset link has been sent successfully");
    }

    @And("^I select remember me option$")
    public void iSelectRememberMeOption() throws Throwable {
        loginPageObject.remember_me();
        LOGGER.info("Remember Me option has been selected successfully");
    }
}
