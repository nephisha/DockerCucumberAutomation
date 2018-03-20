package runner;

//import com.cucumber.listener.ExtentProperties;
//import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;


import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty:STDOUT", "html:target/html-report", "json:target/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent/report.html"},
        tags = {"@tealium"},
        glue = {"steps"}
)
public class TealiumRunner {

 //extends AbstractTestNGCucumberTests

    @BeforeClass
    public static void setup() {
//        ExtentProperties extentProperties = ExtentProperties.INSTANCE;


//        extentProperties.setReportPath("reports/cucumber-extent/report.html");
//        extentProperties.setExtentXServerUrl("http://localhost:1337");
//        extentProperties.setProjectName("MyProject");
    }

    @AfterClass
    public static void reportSetup()
    {
//        Reporter.loadXMLConfig(new File("src/test/resources/features/extent-config.xml"));
//
//	        /*Properties p = System.getProperties();
//	        p.list(System.out);*/
//
//        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
//        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//        Reporter.setSystemInfo("64 Bit", 	"MAC OSX");
//        Reporter.setSystemInfo("3.8.0", "Selenium");
//        Reporter.setSystemInfo("3.5.0", "Maven");
//        Reporter.setSystemInfo("9.0.1", "Java Version");
//        Reporter.setTestRunnerOutput("Cucumber TestNG Test Runner");
    }

}












//import cucumber.api.junit.*;
//import cucumber.api.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
////                format={"pretty", "html:target/test-report"},
////                features = "features",
//                tags= "@login",
//                features = "C:\\woolies-website-automation\\src\\test\\java\\features"
////                glue = {"steps"}
//                )
//
//public class CucumberRunner {
//}


