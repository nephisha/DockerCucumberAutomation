package base;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import support.PropertyReader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;


public class baseStep {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static PropertyReader configfile;
    protected static PropertyReader testdata;
    protected static int sleeptime = 3000;
    protected static Logger LOGGER = Logger.getLogger(baseStep.class.getName());
    protected static Actions actions;
    protected static JavascriptExecutor jse;
    protected static Calendar c;
    protected static SimpleDateFormat formattedDate;
    protected static Date today;
}






//===============

//    private static HashMap<Integer,String> scenarios =  new HashMap<Integer,String>();
//
//    public String getScenario(){
//        Thread currentThread = Thread.currentThread();
//        int threadID = currentThread.hashCode();
//        return scenarios.get(threadID);
//    }
//
//    public void addScenario(String scenario){
//        Thread currentThread = Thread.currentThread();
//        int threadID = currentThread.hashCode();
//        scenarios.put(threadID,scenario);
//    }
//
//    private String createScreeshotFolderStructure() throws IOException {
//
////        DateFormat dateFormat = new SimpleDateFormat("dd_MM_YYYY");
//        Calendar calendar = Calendar.getInstance();
//
//        String folderPath = System.getProperty("user.dir") +  "\\reports\\screenshots\\";
//        System.out.println(folderPath);
//        // + dateFormat.format(new Date()) +"\\"+folderNames[0] + "\\" + folderNames[1]
//        return folderPath;
//
////
//    }
//
//
//    public String capture() throws IOException {
//        String timestamp = new SimpleDateFormat("dd-mm-yyy-HH-mm-ss").format(new Date());
//        String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
////        String folderPath = "reports/screenshots";
//
//
//////        System.out.println(folderPath);
//////                "reports/screenshots"; System.getProperty("user.dir") + "/screenshots"
////
////        TakesScreenshot ts = (TakesScreenshot) this.driver;
////        File source = ts.getScreenshotAs(OutputType.FILE);
////
////        String screenShotDestination = folderPath + timestamp + ".png";
////
////        File destination = new File(screenShotDestination);
////        FileUtils.copyFile(source, destination);
//////        eTest.log("", MediaEntityBuilder.createScreenCaptureFromPath(extentReportImage).build());
//
//
//        String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//        return "data:image/png;base64, " + scnShot ;
//

////        return screenShotDestination;
//    }


//    ==========================



//    public void take_screenshot(Scenario s) {
//        final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
//        s.embed(screenshot, "image/png");
//    }

//    public void takescreenshot() throws IOException {
//        ExtentTest eTest = extent.createTest("TestName");
//        eTest.pass("", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
//    }

//    public Wait(WebElement Wait){
//        return new WebDriverWait(driver, 60);
//    }






//    public boolean isElementDisplayed(List<WebElement> elements ){
//        boolean result = false;
//
//        try{
//
//            if (result = elements.size() > 0){
//                //System.out.println("Element '" + elementName + "' is displayed on the page" );
//                logger.info("Element is displayed on the page" );
//            }
//            else
//            {
//                logger.info("Element is not displayed on the page" );
//            }
//
//        }catch(Exception E){
//            //System.out.println("Element '" + elementName + "' is not displayed on the page" );
//            logger.info("Exception : Element is not displayed on the page" );
//            //logger.error(E);
//        }
//
//        return result;
//    }
//
//    public boolean addExplicitWait(By locator, String condition, int inttimeoutinseconds )
//    {
//
//        boolean status = true;
//        long startTime = System.currentTimeMillis();//this is when the test started
//        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), inttimeoutinseconds, 250L);
//        try
//        {
//            if(condition.equalsIgnoreCase("visibility"))
//            {
//                //webDriverWait.until(ExpectedConditions.visibilityOf(getDriver().findElement(locator)));
//                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//                logger.info("Driver waits explicitly until the element with"+locator.
//                        toString().replace("By."," ")+" is visible");
//            }
//            else if(condition.equalsIgnoreCase("clickable"))
//            {
//                //webDriverWait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(locator)));
//                webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
//                logger.info("Driver waits explicitly until the element with"+locator.
//                        toString().replace("By."," ")+" is clickable");
//            }
//            else if(condition.equalsIgnoreCase("presence"))
//            {
//                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
//                logger.info("Driver waits explicitly until the element with"+locator.
//                        toString().replace("By."," ")+" is present");
//            }
//            else
//                logger.severe("Condition String should be visibility or clickable or presence");
//        }
//        catch(NoSuchElementException e)
//        {
////            reportWarning("No Element found Exception", "The element with"+ locator.toString().replace("By.", " ")+ " not found");
////            logger.error("The element with"
////                    + locator.toString().replace("By.", " ")
////                    + " not found",e.fillInStackTrace());
//            status = false;
//            //throw new NoSuchElementException("The element with"+ locator.toString().replace("By.", " ")+ " not found");
//        }
//        catch(UnsupportedCommandException e)
//        {
////            logger.error("The condition given to check the elemnt with"
////                    + locator.toString().replace("By.", " ")
////                    + " is invalid",e.fillInStackTrace());
//            status = false;
//            //throw new NoSuchElementException("The condition given to check the elemnt with"+ locator.toString().replace("By.", " ")+ " is invalid",e.fillInStackTrace());
//        }
//        catch(TimeoutException e)
//        {
////            logger.error("Timed out after waiting for"
////                            + locator.toString().replace("By.", " ")
////                    ,e.fillInStackTrace());
//            status = false;
////            reportWarning("Timed out after waiting for "+ locator.toString().replace("By.", " "), "");
//            //throw new NoSuchElementException("The condition given to check the elemnt with"+ locator.toString().replace("By.", " ")+ " is invalid",e.fillInStackTrace());
//        }
//        long endTime = System.currentTimeMillis();
//        float seconds = (endTime - startTime) / 1000F;
//        logger.info("Driver waits explicitly until the element with"+locator.toString().replace("By."," ")+" Condition: "+condition+" Wait time: "+Float.toString(seconds));
//        return status;
//    }

