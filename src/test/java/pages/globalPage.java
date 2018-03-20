package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class globalPage extends BasePage {

    public globalPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
    }

// region Page Global Variables - Department Headers

    @FindBy(how = How.CSS, using = ".categoryHeader")
    private List<WebElement> department_header;

    private void ClickDepartmentHeaderLinks(final String btnText) {
        department_header.stream().
                filter(globalLink -> globalLink.getText().equals(btnText)).
                findFirst().get().click();
    }

// end region

// region Page Global Variables - Search Item

    @FindBy(how = How.ID, using = "headerSearch")
    private WebElement search_item;

    @FindBy(how = How.CSS, using = ".iconww-Search")
    private List<WebElement> searchbutton;
// end region

    public void ClickFruitandVeg() {
        ClickDepartmentHeaderLinks("Fruit & Veg");
    }

    public void ClickMeatSeafoodDeli() {
        ClickDepartmentHeaderLinks("Meat, Seafood & Deli");
    }

    public void ClickBakery() {
        ClickDepartmentHeaderLinks("Bakery");
    }

    public void ClickDairyEggsandFridge() {
        ClickDepartmentHeaderLinks("Dairy, Eggs & Fridge");
    }

    public void ClickPantry() {
        ClickDepartmentHeaderLinks("Pantry");
    }

    public void ClickFreezer() {
        ClickDepartmentHeaderLinks("Freezer");
    }

    public void ClickDrinks() {
        ClickDepartmentHeaderLinks("Drinks");
    }

    public void ClickLiquor() {
        ClickDepartmentHeaderLinks("Liquor");
    }

    public void ClickFrontofStore() {
        ClickDepartmentHeaderLinks("Front of Store");
    }

    public void ClickPet() {
        ClickDepartmentHeaderLinks("Pet");
    }

    public void ClickBaby() {
        ClickDepartmentHeaderLinks("Baby");
    }

    public void ClickHealthandBeauty() {
        ClickDepartmentHeaderLinks("Health & Beauty");
    }

    public void ClickHousehold() {
        ClickDepartmentHeaderLinks("Household");
    }

    public void SearchItem(String searchItem){
        switch (searchItem){
            case "Fruit & Veg":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("fruit&vegstockcode"));
                searchbutton();
                break;
            case "Meat,Seafood & Deli":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("meatstockcode"));
                searchbutton();
                break;
            case "Bakery":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("bakerystockcode"));
                searchbutton();
                break;
            case "Dairy,Eggs & Fridge":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("dairystockcode"));
                searchbutton();
                break;
            case "Pantry":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("pantrystockcode"));
                searchbutton();
                break;
            case "Freezer":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("freezerstockcode"));
                searchbutton();
                break;
            case "Drinks":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("drinksstockcode"));
                searchbutton();
                break;
            case "Liquor":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("liquorstockcode"));
                searchbutton();
                break;
            case "Front of Store":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("frontstorestockcode"));
                searchbutton();
                break;
            case "Pet":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("petstockcode"));
                searchbutton();
                break;
            case "Baby":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("babystockcode"));
                searchbutton();
                break;
            case "Health & Beauty":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("health&beautystockcode"));
                searchbutton();
                break;
            case "Household":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("householdstockcode"));
                searchbutton();
                break;
            case "Bundles":
                wait.until(ExpectedConditions.visibilityOf(search_item)).clear();
                search_item.sendKeys(testdata.readProperty("bundlesstockcode"));
                searchbutton();
                break;
            default:
                break;
        }

    }

    public void searchbutton() {
        searchbutton.get(1).click();
    }

//    multisearchLinkContainer
//    multisearch-textbox

}
