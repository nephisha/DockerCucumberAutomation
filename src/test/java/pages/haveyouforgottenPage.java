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

public class haveyouforgottenPage extends BasePage {

    public haveyouforgottenPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
    }


    // region Have You Forgotten Page

    @FindBy(how = How.XPATH, using = "//button[text()='Continue to checkout']")
    private WebElement continuetocheckout;

    //end region

    public void ContinueHYF() {

        try{
            if(continuetocheckout.isDisplayed()){
                continuetocheckout.click();
                LOGGER.info("Have You Forgotten Page is displayed ");
            }
        } catch (Exception e) {
            LOGGER.info("Have You Forgotten Page is not displayed : " + e.getStackTrace());
        }

    }

}
