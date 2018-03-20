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
import java.util.List;


public class productPage extends BasePage {

    public productPage(WebDriver driver) {
//        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20),this);

    }

//    private cartPage cartpageobject = new cartPage(driver);


    // region Page factory variables - Cart
    @FindBy(how = How.CSS, using = ".cartControls-addCart")
    private List<WebElement> addtocart;

    @FindBy(how = How.CSS, using = ".cartOffscreen-openButton")
    private WebElement cartSlider;

    @FindBy(how = How.CSS, using = ".iconww-Plus")
    private List<WebElement> increaseItem;

    @FindBy(how = How.CSS, using = ".iconww-Minus")
    private List<WebElement> decreaseItem;

    // endregion

    public void addtocart() throws Exception {
        Thread.sleep(sleeptime);
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.get(0))).click();
    }

    public void increaseitemcount() throws Exception {
        for (int i = 0; i < 3; i++){
            producttoload();
            wait.until(ExpectedConditions.elementToBeClickable(increaseItem.get(0))).click();
        }
    }

    public void openclosecart() throws Exception {
        Thread.sleep(sleeptime);
        wait.until(ExpectedConditions.elementToBeClickable(cartSlider)).click();
    }

    public void producttoload() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".shelfProductTile-content")));
    }


}
