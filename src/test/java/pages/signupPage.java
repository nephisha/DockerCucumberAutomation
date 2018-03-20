package pages;

import org.apache.velocity.runtime.directive.Break;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

//import sun.jvm.hotspot.debugger.Page;

public class signupPage extends BasePage {

    public signupPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    Random rad = new Random();
    String userfirstname = "bddwowauto" + randomGenerator(6).toLowerCase();
    String userlastename = "bdd" + randomGenerator(6).toLowerCase();
    String useremailid =  userfirstname.concat("@woolworths.com.au");

    // region Page factory variables
    @FindBy(how = How.ID, using = "signupForm-FirstName")
    private WebElement firstname;

    @FindBy(how = How.ID, using = "signupForm-LastName")
    private WebElement lastname;

    @FindBy(how = How.ID, using = "signupForm-EmailAddress")
    private WebElement email_address;

    @FindBy(how = How.ID, using = "signupForm-Password")
    private WebElement email_password;

    @FindBy(how = How.ID, using = "signupForm-DateOfBirth")
    private WebElement date_of_birth;

    @FindBy(how = How.ID, using = "signupForm-MobilePhone")
    private WebElement preferred_contact_number;

    @FindBy(how = How.XPATH, using = ".//*[@for='signupFulfilmentForm-fulfilmentRadio-Courier']")
    private WebElement delivery;

    @FindBy(how = How.XPATH, using = ".//*[@for='signupFulfilmentForm-fulfilmentRadio-Pickup']")
    private WebElement pickup;

    @FindBy(how = How.XPATH, using = ".//*[@for='signupFulfilmentForm-fulfilmentRadio-DecideLater']")
    private WebElement decide_later;

    @FindBy(how = How.ID, using = "address-signupDelivery")
    private WebElement courier_address;

    @FindBy(how = How.CSS, using = ".autocomplete-item")
    private List<WebElement> autocomplete;

//    autocomplete-item  autocomplete-dropdown

    @FindBy(how = How.XPATH, using = ".//*[@for='signupForm-promoSMS']")
    private WebElement sms;

    @FindBy(how = How.XPATH, using = ".//*[@for='signupForm-promoEmails']")
    private WebElement email;

    @FindBy(how = How.ID, using = "signupForm-SignupButton")
    private WebElement signup;


//    @FindBy(how = How.XPATH, using = ".//*[text()='Enter my address manually']")
//    private WebElement manual_address;

    @FindBy(how = How.NAME, using = "street1")
    private WebElement street_address1;

    @FindBy(how = How.NAME, using = "street2")
    private WebElement street_address2;

    @FindBy(how = How.NAME, using = "postCode")
    private WebElement postcode;

    @FindBy(how = How.NAME, using = "suburb")
    private WebElement suburb;

    @FindBy(how=How.ID, using = "pickupAddressSearch-storeSearch")
    private WebElement pickup_address;

    @FindBy(how=How.CSS, using = ".pickupAddressSearch-inputButton")
    private WebElement pickup_address_search;

    @FindBy(how = How.CSS, using = ".pickupAddress-storeDetails")
    private List<WebElement> pickup_store;

    @FindBy(how = How.CSS, using = ".pickupAddress-results")
    private WebElement pickupaddress_results;

    @FindBy(how = How.CSS, using = ".linkButton")
    private List<WebElement> manual_address;

    @FindBy(how = How.CSS, using = ".formValidationSummary-userMessageAndIcon")
    private WebElement form_validation;

    @FindBy(how = How.CSS, using = "._errorMessage")
    private WebElement field_validation;

    @FindBy(how = How.ID, using = "signupForm-FirstName-messages")
    private WebElement firstname_error_message;

    @FindBy(how = How.ID, using = "signupForm-LastName-messages")
    private WebElement lastname_error_message;

    @FindBy(how = How.ID, using = "signupForm-EmailAddress-messages")
    private WebElement emailaddress_error_message;

    @FindBy(how = How.ID, using = "signupForm-Password-messages")
    private WebElement password_error_message;

    @FindBy(how = How.ID, using = "signupForm-MobilePhone-messages")
    private WebElement contactnumber_error_message;

    @FindBy(how = How.ID, using = "address-signupDelivery-messages")
    private WebElement deliveryaddress_error_message;

    @FindBy(how = How.NAME, using = "address")
    private WebElement billing_address;

    private void ClickLinkButton(final String btnText) {
        manual_address.stream().
                filter(LoginBtn -> LoginBtn.getText().contains(btnText)).
                findFirst().get().click();
    }

    @FindBy(how = How.XPATH, using = ".//*[@for='signupForm-isBusiness']")
    private WebElement business_registration;

    @FindBy(how = How.ID, using = "abnForm-ABN")
    private WebElement abn;

    @FindBy(how = How.ID, using = "signupForm-EntityName")
    private WebElement entity_name;

    @FindBy(how = How.ID, using = "signupForm-CompanyName")
    private WebElement company_name;

    @FindBy(how = How.ID, using = "signupForm-businessType")
    private WebElement business_type;

    @FindBy(how = How.ID, using = "signupForm-jobTitle")
    private WebElement job_title;

    @FindBy(how = How.ID, using = "signupForm-EdrNumber")
    private WebElement edr_number;

    @FindBy(how = How.ID, using = "signupForm-EdrPassword")
    private WebElement edr_password;

    @FindBy(how = How.CSS, using = ".paypal-signupButton")
    private WebElement signup_paypal;

    // endregion

    public void enterfirstname() {
        firstname.sendKeys(userfirstname);
    }

    public void enterlastname(){
        lastname.sendKeys(userlastename);
    }

    public void signup_emailaddress() {
        LOGGER.info("Entered Sign-Up Email Address : " + useremailid);
        testdata.writeProperty("testdata","signupusername",useremailid);
        email_address.sendKeys(useremailid);
    }

    public void signup_password() {
        email_password.sendKeys("Woolies123");
    }

    public void date_of_birth(){
        date_of_birth.sendKeys("09/09/1978");
    }

    public void preferred_contact_number(){
        preferred_contact_number.sendKeys("0444444444");
    }

    public void receiving_groceries(String deliverytype){
        switch(deliverytype) {
            case "Delivery":
                delivery.click();
                break;
            case "Pick up":
                pickup.click();
                break;
            case "decide later":
                decide_later.click();
                break;
            default:
                Assert.fail("No such delivery option " + deliverytype + " is available");
        }

    }

    public void enter_address(String addtype) throws Exception  {
        switch(addtype){
            case "Amas":
                courier_address.sendKeys(testdata.readProperty("deliveryaddress"));
                courier_address.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(sleeptime);
                wait.until(ExpectedConditions.elementToBeClickable(autocomplete.get(0))).click();
                break;
            case "Manual":
                ClickLinkButton("Enter my address manually");
                street_address1.sendKeys(testdata.readProperty("streetaddress1"));
                postcode.sendKeys(testdata.readProperty("postcode"));
                Thread.sleep(sleeptime);
                selectDropDownByVisibleText(suburb,testdata.readProperty("suburb"));
                break;
            default:
                Assert.fail("No such address type " + addtype + " is available");
        }

    }

    public void choose_pickup_store() {
        try {
            if(pickupaddress_results.isDisplayed()){
                Thread.sleep(sleeptime);
                pickup_address.clear();
                pickup_address.sendKeys(testdata.readProperty("pickupstorepostcode"));
                pickup_address.sendKeys(Keys.RETURN);
                wait.until(ExpectedConditions.visibilityOf(pickupaddress_results));
                pickup_store.get(0).click();
            }
        } catch (Exception e){
            pickup_address.sendKeys(testdata.readProperty("pickupstorepostcode"));
            pickup_address.sendKeys(Keys.RETURN);
            wait.until(ExpectedConditions.visibilityOf(pickupaddress_results));
            pickup_store.get(0).click();
        }

    }

    public void enter_billing_address(String billtype) throws Exception {
        switch(billtype){
            case "Amas":
                billing_address.sendKeys(testdata.readProperty("billingaddress"));
                billing_address.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(sleeptime);
                wait.until(ExpectedConditions.elementToBeClickable(autocomplete.get(0))).click();
                break;
            case "Manual":
                ClickLinkButton("Enter my address manually");
                street_address1.sendKeys(testdata.readProperty("streetaddress1"));
                postcode.sendKeys(testdata.readProperty("postcode"));
                Thread.sleep(sleeptime);
                selectDropDownByVisibleText(suburb,testdata.readProperty("suburb"));
                break;
            default:
                Assert.fail("No such billing address type " + billtype + " is available");
        }

    }

    public void sign_up() {
        signup.click();
    }

    public void valdation_msg(String arg0, String arg1){
        String strval1 = form_validation.getText();
        String strval2 = field_validation.getText();
        if(strval1.equalsIgnoreCase(arg0) && strval2.equalsIgnoreCase(arg1)){
            LOGGER.info("Form Validation message is displayed as expected");
        } else {
            Assert.fail("Form Validation message is not getting displayed");
        }
    }

    public void errormsg_firstname(String fname_err_msg){
        String strvalue = firstname_error_message.getText();
        if(strvalue.equalsIgnoreCase(fname_err_msg)){
            LOGGER.info("First Name is required Error Message is getting displayed");
        } else {
            Assert.fail("First Name error message is not getting displayed");
        }

    }

    public void errormsg_lastname(String lname_err_msg){
        String strvalue = lastname_error_message.getText();
        if(strvalue.equalsIgnoreCase(lname_err_msg)){
            LOGGER.info("Last Name is required Error Message is getting displayed");
        } else {
            Assert.fail("Last Name error message is not getting displayed");
        }

    }

    public void errormsg_emailaddress(String emailaddr_err_msg){
        String strvalue = emailaddress_error_message.getText();
        if(strvalue.equalsIgnoreCase(emailaddr_err_msg)){
            LOGGER.info("Email Address message " + strvalue + " is getting displayed");
        } else {
            Assert.fail("Email Address error message is not getting displayed");
        }

    }

    public void errormsg_password(String pwd_err_msg){
        String strvalue = password_error_message.getText();
        if(strvalue.equalsIgnoreCase(pwd_err_msg)){
            LOGGER.info("Password is required Error Message is getting displayed");
        } else {
            Assert.fail("Password error message is not getting displayed");
        }

    }

    public void errormsg_contnumber(String contno_err_msg){
        String strvalue = contactnumber_error_message.getText();
        if(strvalue.equalsIgnoreCase(contno_err_msg)){
            LOGGER.info("Preferred Contact Number is required Error Message is getting displayed");
        } else {
            Assert.fail("Preferred Contact Number error message is not getting displayed");
        }

    }

    public void errormsg_address(String addr_err_msg){
        String strvalue = deliveryaddress_error_message.getText();
        if(strvalue.equalsIgnoreCase(addr_err_msg)){
            LOGGER.info("Delivery Address is required Error Message is getting displayed");
        } else {
            Assert.fail("Delivery Address error message is not getting displayed");
        }

    }

    public void abn_details() throws Exception {
        business_registration.click();
        company_name.sendKeys(testdata.readProperty("companyname"));

        String entityNameString = "";

//        abn.sendKeys(testdata.readProperty("abn"));

        int ABNPopulateTry = 0;
        //	System.out.println("Length of ABN entity string:"+ entityNameString.length());

        while(ABNPopulateTry<2 && entityNameString.length()==0){
            String abnVal = testdata.readProperty("abn");
            abn.click();
            abn.clear();
            for (int i = 0; i < abnVal.length(); i++){
                char c = abnVal.charAt(i);
                String s = new StringBuilder().append(c).toString();
                //wait.until(ExpectedConditions.elementToBeClickable(By.id(businessABN))).sendKeys(s);
                abn.sendKeys(s);
            }
            abn.sendKeys(" ");
            abn.sendKeys(Keys.ENTER);
            waitForCZHEADERSpinner();
            try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            waitForElementToGetValue(entity_name);
            entityNameString = entity_name.getAttribute("value");
            ABNPopulateTry++;
        }

        if(entityNameString.length()>0)
            LOGGER.info("Verify Entity Name is pouplated ");
        else{
            Assert.fail("Verify Entity Name is not pouplated");
        }


        String substr = testdata.readProperty("abn").substring(testdata.readProperty("abn").length() - 1);
        System.out.println("Last Digit : " + substr);

        selectDropDownByVisibleText(business_type,testdata.readProperty("businesstype"));
        job_title.sendKeys(testdata.readProperty("jobtitle"));

    }

    public void rewardscarddetails() {
        edr_number.sendKeys(testdata.readProperty("edrnumber"));
        edr_password.sendKeys(testdata.readProperty("edrpassword"));
    }

    public void communication_pref(String comm_pref) {
        switch(comm_pref) {
            case "SMS":
                sms.click();
                break;
            case "Email":
                email.click();
                break;
            default:
                Assert.fail("No such " + comm_pref + " is available");
        }

    }

    public void clickonPayPal() throws Exception {
        Thread.sleep(sleeptime);
        wait.until(ExpectedConditions.visibilityOf(signup_paypal)).click();
    }


}
