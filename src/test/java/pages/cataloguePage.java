package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

//import sun.jvm.hotspot.debugger.Page;

public class cataloguePage extends BasePage {

    public cataloguePage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    // region Page factory variables

    @FindBy(how = How.ID, using = "sf-locationselect-container")
    private WebElement cataloguecontainer;

    @FindBy(how = How.NAME, using = "locationSearch")
    private WebElement postcode;

    @FindBy(how = How.CSS, using = ".autocomplete-suggestion")
    private List<WebElement> autocompletepostcode;

    @FindBy(how = How.ID, using = "sf-location")
    private WebElement cataloguelocation;

    @FindBy(how = How.CSS, using = ".sale-image-cell")
    private List<WebElement> catalogue;

    @FindBy(how = How.XPATH, using = "//*[@id=\"catalogue-first-page-text\"]/h1")
    private WebElement cataloguefirstpagetext;

    // endregion

    public void EnterPostCode() {
        wait.until(ExpectedConditions.visibilityOf(postcode)).sendKeys(testdata.readProperty("postcode"));
        LOGGER.info("PostCode : " + testdata.readProperty("postcode") + " has been entered for searching the catalogue");
    }

    public void StoreSelection(){
        wait.until(ExpectedConditions.elementToBeClickable(autocompletepostcode.get(0))).click();
        LOGGER.info("Store has been selected from the provided list");
    }

    public void VerifyCatalogueDisplay(){
        wait.until(ExpectedConditions.visibilityOf(cataloguelocation));
        LOGGER.info("Catalogue Location : " + cataloguelocation.getText());
    }

    public void CatalogueClickVerify(){
        try{
            if(catalogue.get(0).isDisplayed()){
                wait.until(ExpectedConditions.elementToBeClickable(catalogue.get(0))).click();
            }
        } catch (Exception e){
            wait.until(ExpectedConditions.visibilityOf(cataloguefirstpagetext));
            Assert.assertTrue(cataloguefirstpagetext.getText().equalsIgnoreCase("Weekly Specials Catalogue NSW"));

        }

    }


}
