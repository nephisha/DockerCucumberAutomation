package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

//import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/features",
//        plugin = {"pretty:STDOUT", "junit:target/cucumber-reports/cucumberjunit.xml"},
//        tags = {"@orderplace"},
//        glue = {"steps"}
//)


@RunWith(Cucumber.class)
@CucumberOptions(strict = true, glue = { "steps" },
//        features = { "@target/cucumber-parallel/rerun.txt" },
        features = { "@target/cucumber-parallel/(.*).txt" },
        plugin = { "json:target/cucumber-reports/rerun.json", "pretty",
                "html:target/cucumber-reports/","junit:target/cucumber-reports/cucumberrerunjunit.xml" }
        )

public class ReRunRunner {

 //extends AbstractTestNGCucumberTests

    @BeforeClass
    public static void setup() {

    }

    @AfterClass
    public static void reportSetup() {

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


