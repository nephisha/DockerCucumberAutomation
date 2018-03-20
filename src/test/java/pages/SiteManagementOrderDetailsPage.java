package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SiteManagementOrderDetailsPage extends BasePage {

    public SiteManagementOrderDetailsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    @FindBy(how= How.XPATH, using="(//*[@id='manage-title-panel'])//h1")
    private WebElement orderDetailsTile;

    @FindBy(how=How.CLASS_NAME, using="refund-lines-table")
    private WebElement refundLinesForDispatchedOrder;

    public void verifyOrderDetailsPresenceinSiteMagement()
    {
        boolean refundLinesPresense = wait.until(ExpectedConditions.visibilityOf(refundLinesForDispatchedOrder)).isDisplayed();
        String orderDetailHeading = wait.until(ExpectedConditions.visibilityOf(orderDetailsTile)).getText();
        String expectedTitle = "Issue refund for Order: "+testdata.readProperty("orderNumber").trim()+", Refund ID: new";
        Assert.assertEquals("Verify if refund lines are available for dispatched order", true, refundLinesPresense);
        Assert.assertEquals(expectedTitle, orderDetailHeading);
    }

}
