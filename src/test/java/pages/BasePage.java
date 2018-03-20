package pages;

import base.baseStep;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.PropertyReader;

import java.util.*;
import java.text.SimpleDateFormat;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;


public class BasePage extends baseStep {



    public BasePage() {
        wait = new WebDriverWait(driver,60);
        configfile = new PropertyReader("config");
        testdata = new PropertyReader("testdata");
        actions = new Actions(driver);
        jse = (JavascriptExecutor)driver;
        c = Calendar.getInstance();
        formattedDate = new SimpleDateFormat("yyyy-MM-dd");
        today = new Date();
    }



    public void switchWindows (String number)
    {
        try
        {
            Set<String> AllWindowHandles = driver.getWindowHandles();

            if(number.equals("new"))
            {
                String window2 = (String) AllWindowHandles.toArray()[1];
                System.out.print("\n window2 handle code = "+AllWindowHandles.toArray()[1]);
                driver.switchTo().window(window2);
            }
            else if(number.equals("old"))
            {
                String window1 = (String) AllWindowHandles.toArray()[0];
                System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
                driver.switchTo().window(window1);
            }
        }
        catch (WebDriverException e)
        {
            LOGGER.info("Unable to returm the window handle: " + e.getStackTrace());
            throw new WebDriverException("Unable to return the window handle");
        }
    }

    public String randomGenerator(int length)
    {
        Random generator = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while(i < length){
            char temp =(char) (generator.nextInt(92)+32);
            if(Character.isLetterOrDigit(temp))
            {
                stringBuilder.append(temp);
                ++i;
            }
        }
        System.out.println(stringBuilder);
        return new String(stringBuilder);
    }

    public String todaysDate()
    {
        String actlEndDate;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        actlEndDate = sdf.format(date);
        return actlEndDate;
    }

    public String AddTwoDaysToInputDate(String inputDate){
        String[] arrDate=inputDate.split("/");
        int intDay=Integer.valueOf(arrDate[0]);
        int intMonth=Integer.valueOf(arrDate[1]);
        int intYear=Integer.valueOf(arrDate[2]);
        if(intDay>=27){
            intDay=1;
            if(intMonth==12){
                intMonth=1;
                intYear=intYear+1;
            }
            else{
                intMonth=intMonth+1;
            }
        }
        else{
            intDay=intDay+2;
        }
        String strMonth= Integer.toString(intMonth);
        if (strMonth.length()==1){
            strMonth="0"+strMonth;
        }
        String newDate=Integer.toString(intDay) + "/" + strMonth  + "/" + Integer.toString(intYear);
        return newDate;
    }

    /**
     * Execute a javascript
     */
    public void executeAJSScript(String script)
    {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        javaScriptExecutor.executeScript(script);
        LOGGER.info("The script "+script+" is executed");

    }


    /**
     * This function is to scroll the browser window to a webelement
     * using JavascriptExecutor
     *
     * @param
     * 				- By object of the webelement to which the window has to be scrolled
     */

    public void scrollToElement(WebElement webElement)
    {
//        wait=new WebDriverWait(driver, sleeptime);
        try
        {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            //WebElement webElement = getDriver().findElement(locator);

            //JavascriptExecutor js = (JavascriptExecutor) driver;
            //addExplicitWait(locator, "presence", 15);
            //WebElement webElement = driver.findElement(locator);

            js.executeScript("arguments[0].scrollIntoView(true);",webElement);
            executeAJSScript("window.scrollBy(0,-500)");
            LOGGER.info("Browser window is scrolled to the element");
        }
        catch (NoSuchElementException e)
        {
            LOGGER.info("Unable to scroll: " + e.fillInStackTrace());
			/*throw new NoSuchElementException("The element with"
					+ locator.toString().replace("By.", " ")
					+ " not found");*/
        }
        catch (MoveTargetOutOfBoundsException e)
        {
            LOGGER.info("Unable to scroll: " + e.fillInStackTrace());
            throw new MoveTargetOutOfBoundsException("Target element provided with"
                    +webElement.toString().replace("By."," ")+"is invalid");
        }
        catch(java.lang.Exception e)
        {
            LOGGER.info("Unable to scroll: Exception occured: " + e.fillInStackTrace());
        }

    }


    /**
     * This function is to select a dropdown option using its index
     *
     * @param webelement
     *            - By object to locate the dropdown which is to be selected
     * @param index
     *            - index of the dropdown option to be selected
     */
    public void selectDropDownByIndex(WebElement webelement, int index)
    {
        try
        {
            Select dropDown = new Select(webelement);
            dropDown.selectByIndex(index);
            LOGGER.info("The dropdown option with index " + index
                    + " is selected");
        }
        catch (NoSuchElementException e)
        {
            LOGGER.info("Unable to select the dropdown; The element with"
                    + webelement.toString().replace("By.", " ")
                    + " not found" + e.fillInStackTrace());
            throw new NoSuchElementException("The element with"
                    + webelement.toString().replace("By.", " ")
                    + " not found");
        }
    }


    /**
     * This function is to select the dropdown options that have a value
     * matching the argument
     *
     * @param webelement
     *            - By object to locate the dropdown which is to be selected
     * @param value
     *            - value to match against the dropdown option to be selected
     */
    public void selectDropDownByValue(WebElement webelement, String value)
    {
        try
        {
            Select dropDown = new Select(webelement);
            dropDown.selectByValue(value);
            LOGGER.info("The dropdown option with value " + value
                    + " is selected");
        }
        catch (NoSuchElementException e)
        {
            LOGGER.info("Unable to select the dropdown; The element with"
                    + webelement.toString().replace("By.", " ")
                    + " not found" + e.fillInStackTrace());
            throw new NoSuchElementException("The element with"
                    + webelement.toString().replace("By.", " ")
                    + " not found");
        }
    }


    /**
     * This function is to select the dropdown options that displays text
     * matching the argument
     *
     * @param webElement
     *            - By object to locate the dropdown which is to be selected
     * @param visibleText
     *            - visible text to match against the dropdown option to be
     *            selected
     */
    public void selectDropDownByVisibleText(WebElement webElement, String visibleText)
    {
        try
        {
            Select dropDown = new Select(webElement);
            dropDown.selectByVisibleText(visibleText);
            LOGGER.info("The dropdown option with text " + visibleText
                    + " is selected");
        }
        catch (NoSuchElementException e)
        {
            LOGGER.info("Unable to select the dropdown; The element with"
                    + webElement.toString().replace("By.", " ")
                    + " not found" + e.fillInStackTrace());
            throw new NoSuchElementException("The element with"
                    + webElement.toString().replace("By.", " ")
                    + " not found");
        }
    }


    public boolean isElementDisplayed(WebElement webElement){
        boolean result = false;

        try{
            if(webElement.isDisplayed()){
                result = true;
            }

//            if (result){
//                //System.out.println("Element '" + elementName + "' is displayed on the page" );
//                LOGGER.info("Element is displayed on the page" );
//            }
//            else
//            {
//                LOGGER.info("Element is not displayed on the page" );
//            }

        }catch(Exception E){
            LOGGER.info("Exception happened Element is not displayed on the page" );
        }

        return result;
    }


    /**
     * Wait for Spinner Wheel to stop loading
     */
    public void waitForCZHEADERSpinner()
    {
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();	}
        System.out.println("++++++++++++++++");
        long startTime = System.currentTimeMillis();//this is when the test started

        String smBodyLoad = ".//*[contains(@class,'spinner spinner-circle')]";

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(smBodyLoad)));
        } catch (Exception e1) {
            e1.printStackTrace();
            final List<JavaScriptError> jsErrors = JavaScriptError.readErrors(driver);
            LOGGER.warning("SPINNING WHEEL DISPLAYED BEYOND 60 secs " + jsErrors.toString() + " Wait Condition: Wait For waitForCZHEADERSpinner");
        }
        //*****************************
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;
        LOGGER.info("Wait Condition: Wait For waitForCZHEADERSpinner, loadingSpinner, Wait time: " + Float.toString(seconds));

        System.out.println("++++++++++++++++");
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();	}
    }

    /**
     * Wait for object to get a value
     */
    public boolean waitForElementToGetValue(WebElement webElement)
    {
        boolean result = false;
        try {
            String value = wait.until(ExpectedConditions.visibilityOf(webElement)).getAttribute("value");
            if(value.length() != 0 && !value.equals("0")) {
			        result = true;
			     }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    /**
     * This function is to move the mouse pointer to the specified location
     *
     * @param element
     *            - By object to locate the element to which mouse pointer has
     *            to be moved
     */
    public void mouseOver(WebElement element)
    {
        try
        {
            new Actions(driver).moveToElement(element)
                    .build().perform();
            LOGGER.info("Mouse hover is performed on element with"
                    + element.toString().replace("By.", " "));
        }
        catch (NoSuchElementException e)
        {
            LOGGER.info("Unable to perform MouseOver; The element with");
//                    + element.toString().replace("By.", " ")
//                    + " not found",e.fillInStackTrace());
//            throw new NoSuchElementException("The element with"
//                    + element.toString().replace("By.", " ")
//                    + " not found");
        }
    }


    /**
     * This function is to click on an element by moving the mouse pointer
     * to the specified location or to read the tip of a mouse
     *
     * @param element
     * 				- By object to locate the element to which mouse pointer has
     * 				to be moved
     */
    public void moveMouseTipAndClick(WebElement element)
    {
        try
        {
//            WebElement element = getDriver().findElement(locator);
            Locatable hoverItem = (Locatable) element;
            Mouse mouse = ((HasInputDevices) driver).getMouse();
            mouse.mouseMove(hoverItem.getCoordinates());
            mouse.click(hoverItem.getCoordinates());
        }
        catch(NoSuchElementException e)
        {
            LOGGER.info("Unable to perform click; The element with");
//                    + locator.toString().replace("By.", " ")
//                    + " not found",e.fillInStackTrace());
//            throw new NoSuchElementException("The element with"
//                    + locator.toString().replace("By.", " ")
//                    + " not found");
        }
    }


    /**
     * This function is to click on an element by moving the mouse pointer
     * to the specified location or to read the tip of a mouse
     *
     * @param element1,element2
     * 				- By object to locate the element to which mouse pointer has
     * 				to be moved
     */
    public void moveMouseTipAndClickSubMenu(WebElement element1,WebElement element2)
    {
        try
        {
            actions.moveToElement(element1)
                  .moveToElement(element2).click().build().perform();
            LOGGER.info("Mouse hover is performed on category and clicked on sub category show all link");
        }
        catch(NoSuchElementException e)
        {
            LOGGER.info("Unable to perform click; The element with");
//                    + locator.toString().replace("By.", " ")
//                    + " not found",e.fillInStackTrace());
//            throw new NoSuchElementException("The element with"
//                    + locator.toString().replace("By.", " ")
//                    + " not found");
        }
    }

    /**
     * This method verifies if an element is enabled on the page
     * @param element - Element identifier
     * @return result
     */

    public boolean isElementEnabled(WebElement element){
        boolean result = false;

        try{

            result=wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();

            if (result){
                LOGGER.info("Element is enabled on the page" );
            }

        }catch(Exception E){
            LOGGER.info("Element is not enabled on the page : Exception - " + E );
        }

        return result;
    }

    /**
            * This method verifies if an element is displayed on the page
	 * @param element - Element identifier
	 * @return result
	 */

    public boolean isElementPresent(WebElement element){
        try{
             WebDriverWait wait1 = new WebDriverWait(driver, 5 /*timeout in seconds*/);
             WebElement popup = wait1.until(ExpectedConditions.visibilityOf(element));
             return popup.isDisplayed();


        } catch(Exception ex){
            return false;
        }

    }


    public boolean isAlertPresent(){
        boolean foundAlert = false;
        WebDriverWait wait1 = new WebDriverWait(driver, 5 /*timeout in seconds*/);
        try {
            wait1.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            LOGGER.info("Dialog / Alert box is not available");
        }
        return foundAlert;
    }


}