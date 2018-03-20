package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import support.PropertyReader;

import java.util.List;

public class checkoutPage extends BasePage {

    public checkoutPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }



    // region Page factory variables

    @FindBy(how = How.CSS, using = ".checkoutDeliveryOptions")
    private List<WebElement> deliveryinstructions;

    @FindBy(how = How.CSS, using = ".button")
    private List<WebElement> confirmbutton;

    private void ClickConfirmButton(final String btnText) {
        confirmbutton.stream()
                .filter(btn -> btn.getText()
                        .contains(btnText))
                            .findFirst().get().click();

        //confirmbutton.stream().filter(btn -> btn.getText().contains(btnText)).findFirst().get()
    }

    @FindBy(how = How.CLASS_NAME, using = "paymentSummary-rowAmountText")
    private WebElement subtotal;

    @FindBy(how = How.CSS, using = ".olyDropdown--inline-selectedInlineItem")
    private WebElement paymenttype;

//    @FindBy(how = How.XPATH, using = "//a[@class='olyDropdown--inline-selectedInlineItem']")
//    private WebElement paymenttype;

//    olyDropdown--inline-selectedInlineItem

    @FindBy(how = How.CSS, using = ".olyDropdown-link")
    private List<WebElement> payment;

    @FindBy(how = How.XPATH, using = "//iframe[@class='paymentCreditCard']")
    private WebElement webpaypaymentframe;

    @FindBy(how = How.NAME, using = "cybersource-payment-iframe")
    private WebElement cybersourcepaymentframe;

    @FindBy(how = How.XPATH, using = "//label[text()='Mastercard']")
    private WebElement cybercardtype;

    @FindBy(how = How.XPATH, using = ".//*[@id='CardNumberBox']")
    private WebElement webpaycardNumber;

    @FindBy(how = How.XPATH, using = ".//*[@id='card_number']")
    private WebElement cybercardNumber;

    @FindBy(how = How.ID, using = "ExpiryMonth")
    private WebElement webpaycardExpiryMonth;

    @FindBy(how = How.ID, using = "card_expiry_month")
    private WebElement cybercardExpiryMonth;

    @FindBy(how = How.ID, using = "ExpiryYear")
    private WebElement webpaycardExpiryYear;

    @FindBy(how = How.ID, using = "card_expiry_year")
    private WebElement cybercardExpiryYear;

    @FindBy(how = How.ID, using = "Cvv2")
    private WebElement webpaycardCVV;

    @FindBy(how = How.ID, using = "card_cvn")
    private WebElement cybercardCVV;

    @FindBy(how = How.XPATH, using = "//*[@id='payment_details']/input")
    private WebElement cyberpay;

    @FindBy(how = How.XPATH, using = "//*[@id=\"injectedUnifiedLogin\"]/iframe")
    private WebElement paypalpaymentframe;

    @FindBy(how = How.CSS, using = ".paypal-buttonPanel")
    private WebElement signuppaypal;

    @FindBy(how=How.ID, using = "email" )
    private WebElement paypalusername;

    @FindBy(how=How.ID, using = "password" )
    private WebElement paypalpasword;

    @FindBy(how=How.XPATH, using = "//a[contains(.,'Edit')]")
    private WebElement paypaledit;

    @FindBy(how=How.XPATH, using = ".//*[@id='confirmButtonTop' and @value='Agree and Continue']")
    private WebElement paypalagree;

    @FindBy(how = How.CSS, using = ".olyDialog")
    private WebElement earn_and_learn_dialog;

    @FindBy(how = How.CSS, using = ".olyDialog-close")
    private WebElement earn_and_learn_close;

    //end region

    public void DeliveryInstructionsLoad() {
        wait.until(ExpectedConditions.visibilityOfAllElements(deliveryinstructions));
    }

    public void Subtotal(){
        wait.until(ExpectedConditions.visibilityOf(subtotal));
    }

    public void ClickConfirm() throws Exception {
        Thread.sleep(sleeptime);
        ClickConfirmButton("Confirm");
    }

    public void SelectPaymentType(String payment_type) throws Exception {

            Thread.sleep(sleeptime);
            if(payment_type.equalsIgnoreCase("paypal"))
            {
                try {
                if(signuppaypal.isDisplayed()){
                    signuppaypal.click();
                    LOGGER.info("Sign up for PayPal");
                }

            } catch (Exception e){
                    wait.until(ExpectedConditions.elementToBeClickable(paymenttype)).click();
                    for (int i=0; i < 6;i++){
                        System.out.println(payment.get(i).getText());
                        if (payment.get(i).getText().equals(payment_type)){
                            payment.get(i).click();
                            System.out.println("Was able to successfully click on " + payment_type );
                            if(payment_type.equalsIgnoreCase("paypal")){
                                wait.until(ExpectedConditions.visibilityOf(paypaledit));
                                Thread.sleep(sleeptime);
                                paypaledit.click();
                            }
                            break;
                        } else {
                            System.out.println("The " + payment_type + " payment type is not available");
                        }
                    }

                }
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(paymenttype)).click();
                for (int i=0; i < 6;i++){
                    System.out.println(payment.get(i).getText());
                    if (payment.get(i).getText().equals(payment_type)){
                        payment.get(i).click();
                        System.out.println("Was able to successfully click on " + payment_type );
                        if(payment_type.equalsIgnoreCase("paypal")){
                            wait.until(ExpectedConditions.visibilityOf(paypaledit));
                            Thread.sleep(sleeptime);
                            paypaledit.click();
                        }
                        break;
                    } else {
                        System.out.println("The " + payment_type + " payment type is not available");
                    }
                }
            }

    }

    public void entercarddetails() throws Exception {

        boolean cybersource = isElementDisplayed(cybersourcepaymentframe);
        boolean webpay = isElementDisplayed(webpaypaymentframe);
//        boolean digipay = isElementDisplayed(digipayframe);

        if(cybersource){
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cybersourcepaymentframe));
            wait.until(ExpectedConditions.visibilityOf(cybercardtype));
            cybercardtype.click();
            cybercardNumber.sendKeys(testdata.readProperty("creditCardNo"));

            cybercardCVV.sendKeys(testdata.readProperty("cardCVV"));

            Select dropDownBox = new Select(cybercardExpiryMonth);
            dropDownBox.selectByValue(testdata.readProperty("cardExpiryMonth"));

            Select dropDownBox1 = new Select(cybercardExpiryYear);
            dropDownBox1.selectByValue(testdata.readProperty("cardExpiryYear"));

            LOGGER.info("Payment is made using CyberSource");

            Thread.sleep(sleeptime);
            cyberpay.click();
//            Thread.sleep(sleeptime);


        } else if(webpay){
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webpaypaymentframe));
            webpaycardNumber.sendKeys(testdata.readProperty("creditCardNo"));

            Select dropDownBox = new Select(webpaycardExpiryMonth);
            dropDownBox.selectByVisibleText(testdata.readProperty("cardExpiryMonth"));

            Select dropDownBox1 = new Select(webpaycardExpiryYear);
            dropDownBox1.selectByVisibleText(testdata.readProperty("cardExpiryYear"));

            webpaycardCVV.sendKeys(testdata.readProperty("cardCVV"));

            LOGGER.info("Payment is made using Webpay");

            Thread.sleep(sleeptime);
            ClickConfirmButton("Place order");
//            Thread.sleep(sleeptime);

        } else {
            Assert.fail("The Credit Card Payment Type is incorrect");
        }


    }

    public void paypaldetails() throws Exception {
        Thread.sleep(sleeptime);
        switchWindows("new");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paypalpaymentframe));
        Thread.sleep(sleeptime);
        paypalusername.sendKeys(testdata.readProperty("paypalusername"));
        paypalpasword.sendKeys(testdata.readProperty("paypalpassword"));
        ClickConfirmButton("Log In");
        wait.until(ExpectedConditions.visibilityOf(paypalagree));
        Thread.sleep(sleeptime);
        paypalagree.click();
        switchWindows("old");
        Thread.sleep(10000);
    }

    public void PlaceOrder() throws Exception{
        Thread.sleep(sleeptime);
        ClickConfirmButton("Place order");
    }

    public void earn_learn(){
        try{
            if(earn_and_learn_dialog.isDisplayed()){
                earn_and_learn_close.click();
                LOGGER.info("Earn and Learn Dialog is available for new user");
            }
        } catch (Exception e) {
            LOGGER.info("Earn and Learn Dialog is not available for existing user : " + e.getStackTrace());
        }

    }


}
