package steps.common;

//import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Then;
import org.json.simple.JSONObject;
import org.junit.Assert;
import pages.BasePage;

public class CommonSteps extends BasePage {

//    Util util;

    private Util util = new Util();


    /*******************
     * * @Then Section
     *******************/

    @Then("^I should see tealium tag : (.*) with value : (.*)$")
    public void verify_tealium_tag(String tag, String value) throws Throwable {
        String tealiumLog = util.executeTealiumScript();
//        Reporter.addStepLog("executed tealium script");
        System.out.print(tealiumLog);
        JSONObject json = util.parseJSON(tealiumLog);
//        Reporter.addStepLog("parsing tealium log and verifying the tag");
        Assert.assertEquals("Tag does not match", json.get(tag), value);
}



}
