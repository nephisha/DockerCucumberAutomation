package steps.hooks;

//import com.cucumber.listener.Reporter;
//import com.fasterxml.jackson.databind.ser.Serializers;
//import com.google.common.io.Files;
import base.baseStep;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
//import base.baseStep;
import pages.BasePage;
import support.driverHelpers;

import java.beans.Statement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


public class hooks extends baseStep {
//    private final static Logger LOGGER = Logger.getLogger(hooks.class.getName());
    private driverHelpers driverHelper = new driverHelpers();

//    protected PropertyReader configfile = new PropertyReader("config");
//    protected PropertyReader testdata = new PropertyReader("testdata");

//    public Scenario scenario;



    @Before()
    public void testInitialize(Scenario scenario) throws Exception {
//        this.scenario = scenario;
//        addScenario(scenario.getId()); // this we are using this to retain the
        // feature name and scenario to create
        // individual folder for the screen shots

        driver = driverHelper.retrieveDriver();


        // read all property files
//        System.out.print("This will load uat property before the Scenario");

//         Protected configfile = new PropertyReader("config");
//        testdata = new PropertyReader("testdata");

    }

    @AfterClass
    public void reportSetup() throws IOException {
//        Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/test/resources/features/extent-config.xml"));
//        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//        Reporter.setSystemInfo("64 Bit", "Windows 10");
//        Reporter.setSystemInfo("3.6.0", "Selenium");
//        Reporter.setSystemInfo("3.5.0", "Maven");
//        Reporter.setSystemInfo("9.0.1", "Java Version");
//        Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");
    }

    @After()
    public void teardown(Scenario scenario) throws Exception {

        if(scenario.isFailed()) {

            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());


                String timestamp = new SimpleDateFormat("dd.mm.yyy.HH.mm.ss").format(new Date());
                String folderPath = "target/surefire-reports/screenshots/";
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                File destfile = new File(folderPath + scenario.getName() + ".png");
                FileUtils.copyFile(screenshot, destfile);

                byte[] data = FileUtils.readFileToByteArray(screenshot);
                scenario.embed(data, "image/png");

            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
//                LOGGER.info("YOUR DATA"+somePlatformsDontSupportScreenshots.getStackTrace());
            }


        }


        //    Reporter.addScreenCaptureFromPath(capture(scenario.getName()));
        driverHelper.deleteAllCookies(driver);

        if (scenario.getSourceTagNames().contains("@reset")) {
            driverHelper.close(driver);
        } else {
            driverHelper.release(driver);
        }
    }




}

