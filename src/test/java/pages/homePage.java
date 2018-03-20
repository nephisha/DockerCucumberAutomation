package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class homePage extends BasePage {

    public homePage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60), this);
    }


    // region Page factory variables
    @FindBy(how = How.CSS, using = ".homepage-cta")
    private List<WebElement> loginOrCreateAccount;

    @FindBy(how = How.CLASS_NAME, using = "product")
    private List<WebElement> productsList;

    @FindBy(how = How.CSS, using = ".wow-tab-wrapper")
    private List<WebElement> wowTabWrapper;

    @FindBy(how = How.CSS, using = ".headerCheckout-cartIcon")
    private WebElement trolley;

    @FindBy(how = How.CSS, using = ".cartOffscreen.is-open")
    private WebElement expandcart;

    @FindBy(how = How.CSS, using = ".categoryHeader-navigationLink")
    private List<WebElement> departments;

    @FindBy(how = How.CSS, using = ".coreHeader-profile")
    private WebElement loginprofile;

    @FindBy(css = ".coreHeader-logo")
    private WebElement wowOnlineLogo;

    @FindBy(css = ".corporateHeader-link[href='/shop/storelocator']")
    private WebElement storeLink;

    @FindBy(css = ".corporateHeader-link")
    private List<WebElement> corporateheader;

    @FindBy(css = ".coreHeaderNav-link")
    private List<WebElement> coreHeaderlinks;


    // endregion

    // region Navigate to home page
    public void NavigateTo(String url) {
        driver.navigate().to(url);
    }
    //endregion

    // region HomePage Login Or SignUp Panel

    private void ClickLoginOrCreateAccount(final String btnText) {
        loginOrCreateAccount.stream().
                filter(btn -> btn.getText().equals(btnText)).
                findFirst().get().click();
    }

    public boolean isWowOnineLoaded(){
        wait.until(ExpectedConditions.visibilityOf(wowOnlineLogo));
//                wowOnlineLogo.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
        return wowOnlineLogo.isDisplayed();
    }

    public void clickOnStoreLocator(){
        storeLink.click();
//                wowOnlineLogo.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
        wait.until(ExpectedConditions.visibilityOf(wowOnlineLogo));
    }

    public void ClickLoginOnHomepage(String type) {
        ClickLoginOrCreateAccount(type);
    }

    public void ClickCreateAccount() {
        ClickLoginOrCreateAccount("Create account");
    }
    //endregion

    // region Wow tab wrapper panel

    private void ClickWowTabWrapper(String btnText) {
        wowTabWrapper.stream().
                filter(tabwrapperLink -> tabwrapperLink.getText().equals(btnText)).
                findFirst().get().click();
    }

    public void TrolleyClick() {
        wait.until((ExpectedConditions.elementToBeClickable(trolley))).click();
    }

    public void TrolleyOpenCart(){
        if(expandcart.isDisplayed()){
            LOGGER.info("Cart has been Opened successfully");
            trolley.click();
        } else {
            Assert.fail("Cart did not expand as expected");
        }
    }

    public void ClickBrowseCategory() {
        ClickWowTabWrapper("Browse catalogue");
    }

    public void ClickDeliverySaver() {
        ClickWowTabWrapper("Delivery saver");
    }

    public void ClickFreePickUp() {
        ClickWowTabWrapper("Free Pick up");
    }

    public void ClickEarnRewardsPoints() {
        ClickWowTabWrapper("Earn rewards points");
    }

    public void wow_tab_wrapper_present(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".wow-tab-wrapper")));
    }

    public void loginprofile() {
        wait.until(ExpectedConditions.elementToBeClickable(loginprofile)).click();
    }

    public void CorporateHeaderLinks(String corpheader_link) {

        boolean result = false;
        String mainURL = configfile.readProperty("url_base");
        switch (corpheader_link) {
            case "Shopping":
                for (int i = 0; i < 7; i++) {
                    if (corporateheader.get(i).getText().equalsIgnoreCase(corpheader_link)) {
                        String hrefVal = corporateheader.get(i).getAttribute("href");
                        Assert.assertTrue(hrefVal.equalsIgnoreCase(mainURL));
                        result = true;
                    }
                }
                    if(result){
                        LOGGER.info("Shopping href is matching as expected");
                    } else {
                        Assert.fail("Shopping Link is not available");
                    }

                break;
            case "Stores":
                for (int i = 0; i < 7; i++) {
                    if (corporateheader.get(i).getText().equalsIgnoreCase(corpheader_link)) {
                        String hrefVal = corporateheader.get(i).getAttribute("href");
                        Assert.assertTrue(hrefVal.equalsIgnoreCase(mainURL + "shop/storelocator"));
                        result = true;
                    }
                }
                    if(result){
                        LOGGER.info("Stores href is matching as expected");

                    } else {
                        Assert.fail("Stores Link is not available");
                    }

                break;
            case "Insurance":
                for (int i = 0; i < 7; i++) {
                    if (corporateheader.get(i).getText().equalsIgnoreCase(corpheader_link)) {
                        String hrefVal = corporateheader.get(i).getAttribute("href");
                        Assert.assertTrue(hrefVal.equalsIgnoreCase("https://insurance.woolworths.com.au/"));
                        result = true;
                    }
                }
                    if(result){
                        LOGGER.info("Insurance href is matching as expected");

                    } else {
                        Assert.fail("Insurance Link is not available");
                    }

                break;
            case "Mobile":
                for (int i = 0; i < 7; i++) {
                    if (corporateheader.get(i).getText().equalsIgnoreCase(corpheader_link)) {
                        String hrefVal = corporateheader.get(i).getAttribute("href");
                        Assert.assertTrue(hrefVal.equalsIgnoreCase("https://mobile.woolworths.com.au/"));
                        result = true;
                    }
                }
                    if(result){
                        LOGGER.info("Mobile href is matching as expected");

                    } else {
                        Assert.fail("Mobile Link is not available");
                    }

                break;
            case "Credit Cards":
                for (int i = 0; i < 7; i++) {
                    if (corporateheader.get(i).getText().equalsIgnoreCase(corpheader_link)) {
                        String hrefVal = corporateheader.get(i).getAttribute("href");
                        Assert.assertTrue(hrefVal.equalsIgnoreCase("https://cards.woolworths.com.au/"));
                        result = true;
                    }
                }
                    if(result){
                        LOGGER.info("Credit Cards href is matching as expected");

                    } else {
                        Assert.fail("Credit Cards Link is not available");
                    }

                break;
            case "Rewards":
                for (int i = 0; i < 7; i++) {
                    if (corporateheader.get(i).getText().equalsIgnoreCase(corpheader_link)) {
                        String hrefVal = corporateheader.get(i).getAttribute("href");
                        Assert.assertTrue(hrefVal.equalsIgnoreCase("https://www.woolworthsrewards.com.au/"));
                        result = true;
                    }
                }
                    if(result){
                        LOGGER.info("Rewards href is matching as expected");

                    } else {
                        Assert.fail("Rewards Link is not available");
                    }

                break;
            case "Gift Cards":
                for (int i = 0; i < 7; i++) {
                    if (corporateheader.get(i).getText().equalsIgnoreCase(corpheader_link)) {
                        String hrefVal = corporateheader.get(i).getAttribute("href");
                        Assert.assertTrue(hrefVal.equalsIgnoreCase("https://cards.woolworths.com.au/woolworths-gift-cards.html"));
                        result = true;
                    }
                }
                    if(result){
                        LOGGER.info("Gift Cards href is matching as expected");

                    } else {
                        Assert.fail("Gift Cards Link is not available");
                    }

                break;
            default:
                Assert.fail("No such Corporate Header Link " + corpheader_link + " is available");
        }

    }

    public void CoreHeaderLinks(String coreheader_link) {
        boolean result = false;
        String mainURL = configfile.readProperty("url_base");

                switch (coreheader_link) {
                    case "My Lists":
                        for (int i = 0; i < 4; i++) {
                            if (coreHeaderlinks.get(i).getText().equalsIgnoreCase(coreheader_link)) {
                                String hrefVal = coreHeaderlinks.get(i).getAttribute("href");
                                LOGGER.info("My List href value : " + hrefVal);
                                coreHeaderlinks.get(i).click();
                                result = true;
                            }
                        }

                        if(result){
                            LOGGER.info("My Lists link has been clicked successfully");

                        } else {
                            Assert.fail("My Lists link is not available");
                        }

//                        Assert.assertTrue(hrefVal.equalsIgnoreCase(mainURL + "shop/suggestedlists"));

                        break;
                    case "Catalogue":
                        for (int i = 0; i < 4; i++) {
                            if (coreHeaderlinks.get(i).getText().equalsIgnoreCase(coreheader_link)) {
                                String hrefVal = coreHeaderlinks.get(i).getAttribute("href");
                                Assert.assertTrue(hrefVal.equalsIgnoreCase(mainURL + "shop/catalogue"));
                                coreHeaderlinks.get(i).click();
                                result = true;
                            }
                        }

                        if(result){
                            LOGGER.info("Catalogue link has been clicked successfully");

                        } else {
                            Assert.fail("Catalogue link is not available");
                        }

                        break;
                    case "Recipes":
                        for (int i = 0; i < 4; i++) {
                            if (coreHeaderlinks.get(i).getText().equalsIgnoreCase(coreheader_link)) {
                                String hrefVal = coreHeaderlinks.get(i).getAttribute("href");
                                Assert.assertTrue(hrefVal.equalsIgnoreCase(mainURL + "shop/recipes"));
                                coreHeaderlinks.get(i).click();
                                result = true;
                            }
                        }

                        if(result){
                            LOGGER.info("Recipes link has been clicked successfully");

                        } else {
                            Assert.fail("Recipes link is not available");
                        }

                        break;
                    case "Discover":
                        for (int i = 0; i < 4; i++) {
                            if (coreHeaderlinks.get(i).getText().equalsIgnoreCase(coreheader_link)) {
                                String hrefVal = coreHeaderlinks.get(i).getAttribute("href");
                                Assert.assertTrue(hrefVal.equalsIgnoreCase(mainURL + "shop/discover"));
                                coreHeaderlinks.get(i).click();
                                result = true;
                            }
                        }

                        if(result){
                            LOGGER.info("Discover link has been clicked successfully");

                        } else {
                            Assert.fail("Discover link is not available");
                        }

                        break;
                    default:
                        Assert.fail("No such Core Header Link " + coreheader_link + " is available");
                }


    }

    public void DepartmentHeaderLinks(String departlink){
        for (int i = 0; i < 15; i++) {
              String departVal = departments.get(i).getText();
              if(departVal.equalsIgnoreCase(departlink)) {
                  if(departlink.equalsIgnoreCase("Specials")) {
                      String headercolor = departments.get(i).getCssValue("background-color");
                      String hexheadercolor = Color.fromString(headercolor).asHex();
                      Assert.assertTrue("The Specials Menu Background Color is shown in " + hexheadercolor, hexheadercolor.equalsIgnoreCase("#ffda00"));
                      Assert.assertTrue("The Specials Menu is shown first as expected", i == 0);
                  }
                  departments.get(i).click();
                  LOGGER.info("Able to click successfully on " + departlink + " link");
                  break;
              }
        }
    }


}
