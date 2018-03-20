package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderManagementPage extends BasePage {



    public OrderManagementPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    @FindBy(how = How.LINK_TEXT, using ="Order Management")
    private WebElement orderManagementLink;

    @FindBy(how=How.ID, using="Email")
    private WebElement emailAddress;

    @FindBy(how=How.ID, using="Phone")
    private WebElement phoneNumber;

    @FindBy(how=How.ID, using="ShopperID")
    private WebElement shopperId;

    @FindBy(how=How.ID, using="OrderID")
    private WebElement orderNumber;

    @FindBy(how=How.XPATH, using=".//*[@class='customer-maintenance-column']//*[@id='Email']")
    private WebElement emailAddressinSearchResults;

    @FindBy(how=How.XPATH, using=".//*[@class='customer-maintenance-column']//*[@id='HomePhone']")
    private WebElement phoneNumberinSearchResults;

    @FindBy(how=How.CSS, using="input[value='Customer Search']")
    private WebElement customerSearchButton;

    @FindBy(how=How.CSS, using="input[value='Search']")
    private WebElement SearchButtoninBottom;

    @FindBy(how=How.XPATH, using=".//*[.='Impersonate Customer']")
    private WebElement impersonateShopper;

    @FindBy(how=How.ID, using="B2BDiscount")
    private WebElement B2BdiscountDropdown;

    @FindBy(how=How.ID, using="VendorNumber")
    private WebElement vendorNumber;

    @FindBy(how=How.CSS, using =".coreHeader-profile")
    private WebElement userProfileIcon;

    @FindBy(how=How.ID, using="editPersonalDetails")
    private WebElement editPersonalDetailsLink;

    @FindBy(how=How.ID, using="personalDetailsForm-Email")
    private WebElement emailInputFieldinMyAccount;

    @FindBy(how=How.XPATH, using="(.//td/a)[1]")
    private WebElement resultLink;

    @FindBy(how=How.LINK_TEXT, using="Reset Password")
    private WebElement resetPasswordButtoninCustomerDetails;

    @FindBy(how=How.LINK_TEXT, using="Add New Note")
    private WebElement addNewNoteButton;

    @FindBy(how=How.LINK_TEXT, using="View Notes")
    private WebElement viewNoteButton;

    @FindBy(how=How.CSS, using="form[id=customerForm] fieldset div p")
    private WebElement succeefullyChangedPasswordMessage;

    @FindBy(how=How.CSS, using="input[id=NewPassword]")
    private WebElement newPassword;

    @FindBy(how=How.CSS, using="input[id=ConfirmPassword]")
    private WebElement confirmPassword;

    @FindBy(how=How.XPATH, using="//input[@value='Set Password']")
    private WebElement setPasswordButton;

    //AddShopperNote

    @FindBy(how=How.ID, using="OrderNumber")
    private WebElement OrderNumberInputField;

    @FindBy(how=How.ID, using="QuickContactEntryID")
    private WebElement QuickContactEntryID;

    @FindBy(how=How.ID, using="PrimaryCategoryID")
    private WebElement PrimaryCategoryID;

    @FindBy(how=How.ID, using="SecondaryCategoryID")
    private WebElement SecondaryCategoryID;

    @FindBy(how=How.ID, using="ContactType")
    private WebElement ContactType;

    @FindBy(how=How.ID, using="ContactSummary")
    private WebElement ContactSummary;

    @FindBy(how=How.XPATH, using="//input[@value='Save']")
    private WebElement SaveButton;

    @FindBy(how=How.CSS, using="#popup-panel-close a")
    private WebElement closePopupCSS;

    @FindBy(how=How.CLASS_NAME, using="shoppernote-span-fix-width")
    private WebElement savedShopperNote;

    @FindBy(how = How.ID, using ="FirstName") private WebElement firstNameInputfield;
    @FindBy(how = How.ID, using ="LastName") private WebElement lastNameInputfield;
    @FindBy(how = How.ID, using ="HomePhone") private WebElement homephoneInputfield;

    @FindBy(how = How.ID, using ="BusinessPhone") private WebElement searchbutton;

    @FindBy(how = How.ID, using ="DateOfBirth") private WebElement dobInputField;

    @FindBy(how = How.ID, using ="_customerMaintenanceCompany") private WebElement customerMaintenanceCompany;

    @FindBy(how = How.ID, using ="_customerMaintenanceABN") private WebElement customerMaintenanceABN;

    @FindBy(how = How.ID, using ="JobTitle") private WebElement JobTitle;

    @FindBy(how = How.ID, using ="StatusID") private WebElement StatusID;

    @FindBy(how = How.ID, using ="EdrCardNumber") private WebElement EdrCardNumber;

    @FindBy(how=How.LINK_TEXT, using="Update")
    private WebElement updateButton;

    // Customer Maintenance
    public void enterNewDateOfBirth(String newDateOfBirth)
    {
        dobInputField.clear();
        dobInputField.sendKeys(newDateOfBirth);
    }

    public void clickUpdateButton() throws InterruptedException {
        updateButton.click();
        Thread.sleep(3000);
    }

    public void verifyNewDateOfBirth(String expectedDob)
    {
        String updatedDob = dobInputField.getAttribute("value");
        boolean dobCheck = updatedDob.contains(expectedDob);
        Assert.assertTrue(dobCheck);
    }


    public void navigateToOrderManagement()
    {
        wait.until(ExpectedConditions.visibilityOf(orderManagementLink));
        orderManagementLink.click();
    }

    public void verifyCustomerSearchLandingPage()
    {
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        Assert.assertTrue(emailAddress.isDisplayed());
    }

    public void verifyCustomerSearchURL()
    {
        boolean urlMatchCheck = driver.getCurrentUrl().contains("/CustomerMaintenance/CustomerMaintenanceSearch");
        Assert.assertTrue(urlMatchCheck);
    }

    public void enterEmailAddress()
    {
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        emailAddress.sendKeys(testdata.readProperty("signupusername"));
    }

    public void enterPhoneNumber()
    {
        wait.until(ExpectedConditions.visibilityOf(phoneNumber));
        phoneNumber.sendKeys(testdata.readProperty("phoneNumber"));
    }

    public void enterShopperID()
    {
        wait.until(ExpectedConditions.visibilityOf(shopperId)).sendKeys(testdata.readProperty("shopperId"));
    }

    public void enterOrderNumber(String orderNumberValue)
    {
        wait.until(ExpectedConditions.visibilityOf(orderNumber)).sendKeys(orderNumberValue);
    }

    public void clickCustomerSearch()
    {
        customerSearchButton.click();
    }

    public void clickSearchButtoninBottom()
    {
        SearchButtoninBottom.click();
    }

    public void clickImpersonateShopper()
    {
        impersonateShopper.click();
    }

    public void clickViewNoteButton() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(viewNoteButton));
        viewNoteButton.click();
    }

    public void clickAddNewNoteButton()
    {
        addNewNoteButton.click();
    }

    public void closePopup()
    {
        closePopupCSS.click();
    }
    public void verifySavedShopperNote()
    {
        wait.until(ExpectedConditions.visibilityOf(savedShopperNote));
        Assert.assertEquals(true,driver.findElement(By.xpath("//span[.='This is a manual note for testing']")).isDisplayed());
    }

    public void verifyTheAddShopperNotePopupWithOrderNumberPrepopulated()
    {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(OrderNumberInputField)).isDisplayed());
    }

    public void EnterQuickEntryPrimaryReasonSecondaryReasonContactTypeAndContactSummary()
    {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(QuickContactEntryID)));
        select.selectByIndex(select.getOptions().size()-1);

        select = new Select(wait.until(ExpectedConditions.visibilityOf(PrimaryCategoryID)));
        select.selectByIndex(select.getOptions().size()-1);

        select = new Select(wait.until(ExpectedConditions.visibilityOf(SecondaryCategoryID)));
        select.selectByIndex(select.getOptions().size()-1);

        select = new Select(wait.until(ExpectedConditions.visibilityOf(ContactType)));
        select.selectByIndex(select.getOptions().size()-1);

        ContactSummary.sendKeys("This is a manual note for testing");
    }

    public void clickSaveButton()
    {
        SaveButton.click();
    }

    public void clickResetPasswordButton()
    {
        resetPasswordButtoninCustomerDetails.click();
    }

    public void verifyUserImpersonated()
    {
        switchWindows("new");
        wait.until(ExpectedConditions.visibilityOf(userProfileIcon));
        userProfileIcon.click();
        wait.until(ExpectedConditions.visibilityOf(editPersonalDetailsLink));
        editPersonalDetailsLink.click();
        String actualEmailAddress = emailInputFieldinMyAccount.getAttribute("value");
        Assert.assertEquals(testdata.readProperty("signupusername"),actualEmailAddress);
    }

    public void verifyEmailSearchResult()
    {
        String resultantEMailAddress = wait.until(ExpectedConditions.visibilityOf(emailAddressinSearchResults)).getAttribute("value");
        Assert.assertTrue("Verify search and result email address matches",testdata.readProperty("signupusername").equalsIgnoreCase(resultantEMailAddress));
    }

    public void verifyPhoneNumberSearchResult()
    {
        wait.until(ExpectedConditions.visibilityOf(resultLink)).click();
        String resultantPhoneNumber = wait.until(ExpectedConditions.visibilityOf(phoneNumberinSearchResults)).getAttribute("value");
        Assert.assertEquals(testdata.readProperty("phoneNumber"),resultantPhoneNumber);
    }

    public void verifyShopperIDSearchResult()
    {
        String resultantEmailAddress = wait.until(ExpectedConditions.visibilityOf(emailAddressinSearchResults)).getAttribute("value");
        Assert.assertEquals(testdata.readProperty("siteManagementEmail"),resultantEmailAddress);
    }

    public void verifyB2BfieldsinCustomerSearchResults()
    {
        boolean b2bDiscountDropDownPresence=isElementDisplayed(B2BdiscountDropdown);
        boolean vendorNumberPresence=isElementDisplayed(vendorNumber);

        Assert.assertEquals(b2bDiscountDropDownPresence, true);
        Assert.assertEquals(vendorNumberPresence,true);
    }

    public void iEnterNewPasswordConfirmPasswordAndIClickSetPasswordButton()
    {
        wait.until(ExpectedConditions.visibilityOf(newPassword));
        newPassword.sendKeys("Test123");
        confirmPassword.sendKeys("Test123");
        setPasswordButton.click();
    }

    public void verifyPasswordResetSuccessMessageinSiteManagement()
    {
        wait.until(ExpectedConditions.visibilityOf(succeefullyChangedPasswordMessage));
        String resetMessage = succeefullyChangedPasswordMessage.getText();
        Assert.assertEquals("User will be prompted to change password on next login.", resetMessage);
    }


}
