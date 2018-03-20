package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class orderconfirmationPage extends BasePage {

    public orderconfirmationPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }


    // region Page factory variables
    @FindBy(how = How.CSS, using = ".checkoutConfirmation")
    private List<WebElement> confirmationpage;

    @FindBy(how = How.CSS, using = ".checkoutConfirmationOrderDetails-orderDetailsText")
    private List<WebElement> ordernumber;
    //end region

    public void ordercapture(){
        wait.until(ExpectedConditions.visibilityOfAllElements(confirmationpage));
        String OrderNo = ordernumber.get(0).getText();
        System.out.println("\n Order Number : " + OrderNo);
    }

}
