package pages;

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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class orderDiscountPage extends BasePage {

    public orderDiscountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60), this);
    }

    String orderpromotionname = "bddorderpromo" + randomGenerator(6).toLowerCase();

    @FindBy(how = How.TAG_NAME, using = "a")
    private List<WebElement> manageMenuItem;

    @FindBy(how=How.ID, using="Email")
    private WebElement siteManagementEmail;

    @FindBy(how=How.ID, using="Password")
    private WebElement siteManagementPassword;

    @FindBy(how=How.XPATH, using=".//*[@value='Login']")
    private WebElement submitButtoninLogin;

    @FindBy(how=How.LINK_TEXT, using = "Log Off")
    private WebElement logOffLink;


    @FindBy(how=How.ID, using="Name")
    private WebElement nameInputField;

    @FindBy(how=How.ID, using="Rank")
    private WebElement rankInputField;

    @FindBy(how=How.ID, using="StartDate")
    private WebElement StartDateInputField;

    @FindBy(how=How.ID, using="EndDate")
    private WebElement EndDateInputField;

    @FindBy(how=How.ID, using="sessionGroup")
    private WebElement sessionGroupDropDown;

    @FindBy(how=How.ID, using="MinimumOrderValue")
    private WebElement MinimumOrderValueInputField;

    @FindBy(how=How.ID, using="Target")
    private WebElement TargetDropDown;

    @FindBy(how=How.ID, using="AwardType")
    private WebElement discountTypeDropDown;

    @FindBy(how=How.ID, using="Amount")
    private WebElement AmountInputField;

    @FindBy(how=How.ID, using="OfferID")
    private WebElement OfferIDInputField;

    @FindBy(how=How.XPATH, using=".//input[@value='Update']")
    private WebElement updateButton;




    /**
     * Login SiteManagement
     */
    public void LoginSiteManagement()
    {
        siteManagementEmail.sendKeys(testdata.readProperty("siteManagementEmail"));
        siteManagementPassword.sendKeys(testdata.readProperty("siteManagementPassword"));
        submitButtoninLogin.click();
        WaitForLogOff();
    }

    public void WaitForLogOff(){
        wait.until(ExpectedConditions.visibilityOf(logOffLink));
    }
    /**
     * Navigate to Menu through Link Names 2 level
     */
    public void navigateThroughMenu(String menu1, String menu2)
    {
        manageMenuItem.stream().
                filter(btn -> btn.getText().equals(menu1)).
                findFirst().get().click();
        manageMenuItem.stream().
                filter(btn -> btn.getText().equals(menu2)).
                findFirst().get().click();
    }

    /**
     * Navigate to Menu through Link Names 2 level
     */
    public void navigateThroughMenu(String menu1)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(menu1)));
        manageMenuItem.stream().
                filter(btn1 -> btn1.getText().equals(menu1)).
                findFirst().get().click();
    }

    public void enterName(){
        nameInputField.sendKeys(orderpromotionname);
    }

    public void enterRank(){
        rankInputField.sendKeys("0");
    }

    public void enterStartDate()
    {
        StartDateInputField.sendKeys(todaysDate());
    }

    public void enterEndDate()
    {
        EndDateInputField.sendKeys(AddTwoDaysToInputDate(todaysDate()));
        EndDateInputField.sendKeys(Keys.TAB);
    }

    public void selectEligibleShoppers(String sessionGroupValue)
    {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(sessionGroupDropDown)));
        select.selectByVisibleText(sessionGroupValue);
    }

    public void enterQualifyingAmount()
    {
        //MinimumOrderValueInputField.click();
        MinimumOrderValueInputField.clear();
        MinimumOrderValueInputField.sendKeys("30");
    }

    public void enterTarget(String targetValue)
    {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(TargetDropDown)));
        select.selectByVisibleText(targetValue);
    }

    public void selectDiscountType(){
        //% - Percent Off

        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(discountTypeDropDown)));
        select.selectByVisibleText("% - Percent Off");
    }

    public void enterAmount(){ AmountInputField.clear(); AmountInputField.sendKeys("8");}

    public void enterOfferID(){ OfferIDInputField.sendKeys("123456"); }

    public void clickUpdateButton() { updateButton.click();}

    public void verifyIfOrderPromotionSaved() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orderpromotionname)));
        boolean orderPromoPresence = isElementDisplayed(element);
        Assert.assertTrue(orderPromoPresence);
    }

}
