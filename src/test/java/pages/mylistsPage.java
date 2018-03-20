package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

//import sun.jvm.hotspot.debugger.Page;

public class mylistsPage extends BasePage {

    public mylistsPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    // region Page factory variables

    @FindBy(how = How.CSS, using = ".savedLists-listsContainer")
    private WebElement savedlist;


    // endregion

    public void SavedListContainerVerify(String login_type) {
        try{
            switch (login_type){
                case "Not Logged In":
                    if (savedlist.isDisplayed()){
                        Assert.fail("For a Not Logged In Customer Saved Lists should not be displayed");
                    }
                    break;
                case "Logged In":
                    if (savedlist.isDisplayed()){
                        String currentURL = driver.getCurrentUrl();
                        Assert.assertThat(currentURL, containsString("mylists"));
                        LOGGER.info("Saved List is displayed as expected");
                    }
                    break;
                default:
                    Assert.fail("No such user exists");

            }

        } catch (Exception e){
            if (login_type.equalsIgnoreCase("Not Logged In")){
                String currentURL = driver.getCurrentUrl();
                Assert.assertThat(currentURL, containsString("suggestedlists"));
                LOGGER.info("Saved List Container is not displayed for Not Logged In Customer");
            } else {
                LOGGER.info("Exception Occured : " + e.getStackTrace());
                Assert.fail("Failed to Verify Saved Lists Container");
            }
        }

    }


    public void ClickMyWoolworthsList() {
    }
}
