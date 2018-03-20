package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class loginPage extends BasePage {

    public loginPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    // region Page factory variables
    @FindBy(how = How.CSS, using = ".formValidationSummary")
    private List<WebElement> formValidationSummary;

    @FindBy(how = How.CSS, using = ".secureLogin-form")
    private WebElement GetLoginPanel;

    @FindBy(how = How.ID, using = "loginForm-Email")
    private WebElement email_address;

    @FindBy(how = How.ID, using = "loginForm-Password")
    private WebElement email_password;

    @FindBy(how = How.CSS, using = ".loginForm-button")
    private List<WebElement> login_button;

    @FindBy(how = How.XPATH, using = "//*[contains(@href,'/shop/signup')]")
    private WebElement signup;

    @FindBy(how = How.XPATH, using = "//*[contains(@href,'/shop/forgotpassword')]")
    private WebElement forgotpassword;

    @FindBy(how = How.ID, using = "forgotPasswordForm-email")
    private WebElement forgotpwd_email_address;

    @FindBy(how = How.XPATH, using = "//*[@id=\"forgotPasswordForm\"]/div/button")
    private WebElement forgotsendbtn;

    @FindBy(how = How.XPATH, using = "//*[contains(@setting-name,'ReminderResultSent')]")
    private WebElement passwordresettext;

    @FindBy(how = How.CSS, using = ".loginForm-rememberMe")
    private WebElement rememberme;


    private void ClickLoginOnLoginPage(final String btnText) {
        login_button.stream().
                filter(LoginBtn -> LoginBtn.getText().contains(btnText)).
                findFirst().get().click();
    }

    // endregion

    public void EnterEmail(String login_type)
    {
        if(login_type.equalsIgnoreCase("paypal"))
        {
            email_address.sendKeys(testdata.readProperty("wowpaypalusername"));
        }
        else if(login_type.equalsIgnoreCase("webpay payment"))
        {
            email_address.sendKeys(testdata.readProperty("webpayloginusername"));
        }
        else if(login_type.equalsIgnoreCase("cybersource payment"))
        {
            email_address.sendKeys(testdata.readProperty("cybersourceloginusername"));
        } else if(login_type.equalsIgnoreCase("cybersource1 payment")) {
            email_address.sendKeys(testdata.readProperty("cybersourceloginusername1"));
        } else if(login_type.equalsIgnoreCase("cybersource2 payment")) {
            email_address.sendKeys(testdata.readProperty("cybersourceloginusername2"));
        } else if(login_type.equalsIgnoreCase("webpay1 payment")) {
            email_address.sendKeys(testdata.readProperty("webpayloginusername1"));
        } else if(login_type.equalsIgnoreCase("webpay2 payment")) {
            email_address.sendKeys(testdata.readProperty("webpayloginusername2"));
        }
        else if(login_type.equalsIgnoreCase("woolworths rewards"))
        {
            email_address.sendKeys(testdata.readProperty("rewardsloginusername"));
        }
    }

    public void EnterPassword(String login_type) {
        if(login_type.equalsIgnoreCase("paypal")){
            email_password.sendKeys(testdata.readProperty("wowpaypalpassword"));
        } else if(login_type.equalsIgnoreCase("webpay payment")){
            email_password.sendKeys(testdata.readProperty("webpayloginpassword"));
        } else if(login_type.equalsIgnoreCase("cybersource payment")){
            email_password.sendKeys(testdata.readProperty("cybersourceloginpassword"));
        } else if(login_type.equalsIgnoreCase("cybersource1 payment")){
            email_password.sendKeys(testdata.readProperty("cybersourceloginpassword"));
        } else if(login_type.equalsIgnoreCase("cybersource2 payment")){
            email_password.sendKeys(testdata.readProperty("cybersourceloginpassword"));
        } else if(login_type.equalsIgnoreCase("webpay1 payment")) {
            email_password.sendKeys(testdata.readProperty("webpayloginpassword"));
        } else if(login_type.equalsIgnoreCase("webpay2 payment")) {
            email_password.sendKeys(testdata.readProperty("webpayloginpassword"));
        }else if(login_type.equalsIgnoreCase("woolworths rewards"))
        {
            email_password.sendKeys(testdata.readProperty("rewardsloginpassword"));
        }
    }

    public void ClickLoginOnLoginPage() {
        ClickLoginOnLoginPage("Login");
    }


    public void ClickForgotPassword() {
        GetLoginPanel.findElement(By.cssSelector(".loginForm-forgotPassword")).click();
    }

    public void ClickRemeberme() {
        GetLoginPanel.findElement(By.className("loginForm-rememberMe")).click();
    }

//    public void ClickLoginOnLoginPage() {
//        WebElement loginBtn = GetLoginPanel.
//                findElements(By.cssSelector(".loginForm-button")).stream().
//                filter(btn -> btn.getAttribute("textContent").contains("Login")).
//                findFirst().get();
//        loginBtn.click();
//    }

    //endregion


    private WebElement GetValidationSummary() {
        return formValidationSummary.size() > 0 ? formValidationSummary.get(0) : null;
    }

    public String GetValidationSummaryUserMessage() {
        List<WebElement> validationSummaryuserMessage = GetValidationSummary().findElements(By.cssSelector(".formValidationSummary-userMessageAndIcon"));
        return validationSummaryuserMessage.size() > 0 ? validationSummaryuserMessage.get(0).getText() : null;
    }

    public String GetValidationSummaryErrorMessage() {
        List<WebElement> validateionSummaryErrorMessage = GetValidationSummary().findElements(By.cssSelector(".formValidationSummary-userMessageAndIcon ~ button"));
        return validateionSummaryErrorMessage.size() > 0 ? validateionSummaryErrorMessage.get(0).getText() : null;
    }

    public String GetValidationMessageForInvalidUserLogin() {
        List<WebElement> serverErrorValidationMessage = GetValidationSummary().findElements(By.cssSelector(".alert-serverErrorMessage"));
        return serverErrorValidationMessage.size() > 0 ? serverErrorValidationMessage.get(0).getText() : null;
    }

//    public String GetMandatoryOrFormatMailErrorMessage() {
//        List<WebElement> emailErrorMessage = GetLoginPanel().findElements(By.id("loginForm-Email-messages"));
//        return emailErrorMessage.size() > 0 ? emailErrorMessage.get(0).getText() : null;
//    }
//
//    public String GetMandatoryPasswordErrorMessage() {
//        List<WebElement> passwordErrorMessage = GetLoginPanel().findElements(By.id("loginForm-Password-messages"));
//        return passwordErrorMessage.size() > 0 ? passwordErrorMessage.get(0).getText() : null;
//    }
//
//    public void ClickSignUpOnLoginPanel() {
//        GetLoginPanel().findElement(By.cssSelector(".secureLogin-signUp")).click();
//    }

    public void SignUpLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signup)).click();
    }

    public boolean IsPageLoaded() {
        return true;
    }

    public void ForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotpassword)).click();
    }

    public void PasswordReset() {
        forgotpwd_email_address.sendKeys(testdata.readProperty("cybersourceloginusername"));
        forgotsendbtn.click();
        String pwdStrVal = passwordresettext.getText();
        Assert.assertTrue("The Password rest link has been sent to : " + testdata.readProperty("cybersourceloginusername"), pwdStrVal.equalsIgnoreCase("If your email is valid a reset link will be sent"));
    }

    public void remember_me() {
        rememberme.click();
    }


}
