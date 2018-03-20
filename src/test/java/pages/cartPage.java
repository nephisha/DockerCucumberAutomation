package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class cartPage extends BasePage {

    public cartPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
    }


// // Create object of SimpleDateFormat class and decide the format
//    Date today = new Date();
//    SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-mm-dd");




 // region Page factory variables - Cart Elements
    @FindBy(how = How.CSS, using = ".fulfilmentMethodWizard-fulfilmentMethod-label")
    private List<WebElement> deliverymethod;

    private void ClickonDeliveryMethod(final String btnText) {
        deliverymethod.stream().
                filter(deliverymethodLink -> deliverymethodLink.getText().contains(btnText)).
                findFirst().get().click();
    }

    @FindBy(how = How.XPATH, using = "//*[contains(@ng-click,'openAddressesSelection()')]")
    private WebElement addressselection;

    @FindBy(how = How.ID, using = "savedAddresses-results")
    private WebElement savedaddress;

    @FindBy(how = How.CSS, using = ".spinner-circle")
    private List<WebElement> spinningwheeladdress;

    @FindBy(how = How.ID, using = "address-savedAddress")
    private WebElement address;

    @FindBy(how = How.ID, using="savedAddresses-results")
    private WebElement previoussavedaddress;

    @FindBy(how = How.CSS, using = ".autocomplete-item")
    private List<WebElement> autocomplete;


    @FindBy(how = How.XPATH, using = ".//input[@class='wowRadio' and @type='radio']")
    private List<WebElement> selectdatetime;

    @FindBy(how = How.CSS, using = ".fulfilmentTimetable-timeSelector")
    private WebElement dateandtimecontainer;


    @FindBy(how = How.CSS, using = ".iconww-ArrowDown")
    private List<WebElement> downarrow;

    @FindBy(how = How.NAME, using = "selectedTime")
    private List<WebElement> selecttime;

    @FindBy(how = How.CSS, using = ".cartDeliveryFee-priceContainer")
    private WebElement deliveryfee;

    @FindBy(how = How.CSS, using = ".cart-clearCart")
    private List<WebElement> remove_all_products;

    @FindBy(how = How.CSS, using = ".linkButton")
    private List<WebElement> removeitems;

    private void ClickButton(final String btnText) {
        removeitems.stream().
                filter(btn -> btn.getText().contains(btnText)).
                findFirst().get().click();
    }

    @FindBy(how = How.XPATH, using = "//*[contains(@href,'checkout')]")
    private WebElement checkout;

    @FindBy(how = How.CSS, using = ".modalDialog")
    private WebElement dialogbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalDialog-textBody\"]")
    private WebElement liquorrestrictmessage;

    @FindBy(how = How.XPATH, using = ".//a[@class='modalDialog-dismiss']")
    private WebElement dialogclose;

    @FindBy(how = How.XPATH, using = "//*[@setting-name='RestrictionWarningDeliverySignatureAndPhotoId']")
    private WebElement restrictwarning;

    @FindBy(how = How.XPATH, using = ".//a[@ng-click='$ctrl.openTimeslots()']")
    private WebElement changetimeslot;

    @FindBy(how = How.XPATH, using = ".//a[@ng-click='$ctrl.openBilling()']")
    private WebElement changebillingadress;

    // endregion

//    public List<WebElement> getDateTime(){
//        return selectdatetime;
//    }
//
//    public List<WebElement> getDownArrow(){
//        return downarrow;
//    }

    public void ChooseDeliveryMethod(String deliverytype) {
        ClickonDeliveryMethod(deliverytype);
    }

    public void AddressSelection(){
        addressselection.click();
    }

    public void DeliveryAddress (String deliveryaddrstype) throws Exception {
//    //Tealium Issue had to add extra step to handle the extra refresh
//        Thread.sleep(25000);
//        ClickonDeliveryMethod("Delivery");

        switch (deliveryaddrstype){
            case "Amas":
                wait.until(ExpectedConditions.invisibilityOfAllElements(spinningwheeladdress));
                wait.until(ExpectedConditions.visibilityOf(previoussavedaddress));
//        deliveryfee.click();
                scrollToElement(address);
                address.sendKeys(testdata.readProperty("deliveryaddress"));
                address.click();
                address.sendKeys(Keys.BACK_SPACE);
                address.click();
                Thread.sleep(sleeptime);
                wait.until(ExpectedConditions.elementToBeClickable(autocomplete.get(0))).click();
                break;
            case "Manual":
                break;
            case "Saved":
                break;
            default:
                Assert.fail("There is no Delivery Address for this type : " + deliveryaddrstype);

        }

    }

    public void dateselection() throws Exception {

        for (int i = 0; i < 7; i++) {
            wait.until(ExpectedConditions.visibilityOf(dateandtimecontainer));
            boolean dateselection = isElementEnabled(selectdatetime.get(i));
//            boolean dateselection = driver.findElement(By.xpath("//*[@id='" + strDate + "']")).isEnabled();
                if(dateselection){
                    c.add(Calendar.DATE, i);  // number of days to add
                    String strDate = (String)(formattedDate.format(c.getTime()));
                    LOGGER.info("The Date Selected for Delivery : " + strDate);
//                    actions.moveToElement(selectdatetime.get(i)).click().perform();
                    jse.executeScript("arguments[0].click()", selectdatetime.get(i));
                    break;
                }
        }
    }

    public void timeselection() throws Exception {

        for (int j = 7; j < 20; j++) {
            boolean timeselection = isElementEnabled(selectdatetime.get(j));
            if (timeselection) {
//                actions.moveToElement(selectdatetime.get(j)).click().perform();
                jse.executeScript("arguments[0].click()", selectdatetime.get(j));
                Thread.sleep(sleeptime);
                break;
            }
        }
    }

    public void restricteddialogbox() {
        try{
            if(isElementPresent(dialogbox)){
                String strLiquorMessage = liquorrestrictmessage.getText();
                LOGGER.info("Liquor Message : " + strLiquorMessage);
                if(strLiquorMessage.matches("Due to liquor licensing restrictions we are unable to supply liquor items within your selected delivery/pick up window.(.*)")){
                    dialogclose.click();
                    wait.until(ExpectedConditions.elementToBeClickable(changetimeslot)).click();
                    for (int j = 10; j < 18; j++) {
                        boolean timeselection = isElementEnabled(selectdatetime.get(j));
                        if (timeselection) {
                            jse.executeScript("arguments[0].click()", selectdatetime.get(j));
                            Thread.sleep(sleeptime);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.info("No Restriction in adding the items to the trolley");
        }
    }

    public void ClickonCheckout(){
//        ClickCheckoutButton("Checkout");
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    public void RemoveAllProducts(){

        try{
            if(remove_all_products.size() > 0){
                remove_all_products.get(0).click();
                ClickButton("Yes");
                System.out.println("All the items have been removed from the cart");
            }

        } catch (Exception e) {
            LOGGER.info("Exception : " + e.getStackTrace());
        }

    }

    public void IChooseATimeLater() {
        ClickButton("I'll choose a time later");
        LOGGER.info("User has choosen to select a time slot later");
    }

    public void RestrictionWarningDelivery() {
        LOGGER.info("Restriction Warning Message For Delivery : " + restrictwarning.getText());
        Assert.assertTrue(restrictwarning.getText().matches("Your order contains restricted items.(.*)"));
    }

    public void ClickChangeBillingAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(changebillingadress)).click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(spinningwheeladdress));
        wait.until(ExpectedConditions.visibilityOf(previoussavedaddress));
    }


}
