package support;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.awt.*;
//import java.awt.*;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class driverHelpers {
    private static List<WebDriver> availableDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());
    private static List<WebDriver> activeDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());
    private PropertyReader configfile = new PropertyReader("config");

//    Toolkit toolkit = Toolkit.getDefaultToolkit();
//
//    Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight());

//    int screenwidth = (int) toolkit.getScreenSize().getWidth();
//    int screenheight = (int) toolkit.getScreenSize().getHeight();

    public static void closeAll() {
        for (WebDriver driver : availableDrivers) {
            driver.quit();
        }
    }

    public WebDriver retrieveDriver() throws Exception {
        WebDriver driver;
        if (availableDrivers.size() > 0) {
            driver = availableDrivers.remove(0);
            activeDrivers.add(driver);
        } else {
            driver = createDriver();
            activeDrivers.add(driver);
        }

//        driver.manage().window().fullscreen();


        return driver;
    }

    private WebDriver createDriver() throws Exception {
        return createDriver(configfile.readProperty("browser"));
    }

    private WebDriver createDriver(String driverType) throws Exception {

        String os = System.getProperty("os.name").toLowerCase();

        WebDriver driver;

            switch (configfile.readProperty("browser")) {
                case "firefox":
                    if(os.contains("mac")){
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/firefox/geckodriver");
                        driver = new FirefoxDriver();
//                        driver.manage().window().setSize(screenResolution);
                        break;
                    } else {
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/firefox/geckodriver.exe");
                        driver = new FirefoxDriver();
//                        driver.manage().window().maximize();
//                        driver.manage().window().setSize(screenResolution);
                        break;
                    }

                case "chrome":
                    if(os.contains("mac")){

//                        //Code for running localing
//                        Toolkit toolkit = Toolkit.getDefaultToolkit();
//
//                        Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight());
//
//                        int screenwidth = (int) toolkit.getScreenSize().getWidth();
//                        int screenheight = (int) toolkit.getScreenSize().getHeight();
//                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver");
////
//                        driver = new ChromeDriver();
//                        driver.manage().window().setSize(screenResolution);
//
////                        ChromeOptions options = new ChromeOptions();
////                        options.addArguments("--kiosk");  //--start-maximized  --kiosk"
////                        driver = new ChromeDriver(options);
//                        break;

                        //Code for running in Docker
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--kiosk");
                        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),options);
                        break;

                    } else if(os.contains("linux")) {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver_linux");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--kiosk");
                        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),options);
                        break;

                    } else {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver.exe");
//                        ChromeOptions options = new ChromeOptions();
//                        options.addArguments("--start-maximized");
                        driver = new ChromeDriver();  //options
                        driver.manage().window().maximize();

//                        JavascriptExecutor executor = (JavascriptExecutor) driver;
//                        executor.executeScript("window.resizeTo("+ screenwidth +", "+ screenheight +");");

//                        driver.manage().window().setSize(screenResolution);
                        break;
                    }


                case "ie":
                    if(os.contains("mac")){

                    } else {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/ie/iedriver.exe");
                        driver = new InternetExplorerDriver();
                        break;
                    }

                case "headless":
                    if(os.contains("mac")){
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver");
//                        ChromeOptions options = new ChromeOptions();
//                        options.addArguments("headless");
                        driver = new ChromeDriver();
//                        driver.manage().window().setSize(screenResolution);
                        break;
                    } else {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome/chromedriver.exe");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("headless");
                        driver = new ChromeDriver();  //options
                        driver.manage().window().maximize();
                        break;
                    }

                default:
                    throw new Exception("The browser: " + configs.Browser + " is not supported yet.");
            }

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // 60
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); // 120

//        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//        int width = gd.getDisplayMode().getWidth();
//        int height = gd.getDisplayMode().getHeight();
//
//        driver.manage().window().setSize(new Dimension(width,height));
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenResolution();
//        double width = screenSize.getWidth();
//        double height = screenSize.getHeight();

//        driver.manage().window().maximize();


        return driver;
    }

    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void close(WebDriver driver) throws Exception {
        deleteAllCookies(driver);
        activeDrivers.remove(driver);
        driver.quit();
    }

    public void release(WebDriver driver) {
        deleteAllCookies(driver);
        activeDrivers.remove(driver);
        availableDrivers.add(driver);
    }
}
