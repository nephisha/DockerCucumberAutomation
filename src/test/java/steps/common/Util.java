package steps.common;

//import net.serenitybdd.core.pages.PageObject;
//import net.serenitybdd.core.pages.WebElementFacade;
//import net.thucydides.core.util.EnvironmentVariables;
//import net.thucydides.core.util.SystemEnvironmentVariables;
//import base.baseStep;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
//import woolworths.com.cucumber.pages.BasePage;
import pages.BasePage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Util extends BasePage {

    public static boolean isAttributePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

//    public static String getEnvironment(){
//        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
//        return variables.getProperty("environment");
//    }

    public static String getMessage(String key){
        String resourceName = "messages.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        String messageValue = "";
        try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            props.load(resourceStream);
            messageValue = props.get(key).toString();
        }
        catch (IOException e){}
        return messageValue;
    }

//    public static String getProperty(String key){
//        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
//        return variables.getProperty(key);
//    }

    public Boolean isElementPresentInViewPort(WebElement element){
//        return (Boolean)evaluateJavascript("function isElementVisible(el) {\n" +
          return (Boolean)((JavascriptExecutor) driver).executeScript("function isElementVisible(el) {\n" +
                "    var rect     = el.getBoundingClientRect(),\n" +
                "        vWidth   = window.innerWidth || doc.documentElement.clientWidth,\n" +
                "        vHeight  = window.innerHeight || doc.documentElement.clientHeight,\n" +
                "        efp      = function (x, y) { return document.elementFromPoint(x, y) };\n" +
                "\n" +
                "    // Return false if it's not in the viewport\n" +
                "    if (rect.right < 0 || rect.bottom < 0 \n" +
                "            || rect.left > vWidth || rect.top > vHeight)\n" +
                "        return false;\n" +
                "\n" +
                "    // Return true if any of its four corners are visible\n" +
                "    return (\n" +
                "          el.contains(efp(rect.left,  rect.top))\n" +
                "      ||  el.contains(efp(rect.right, rect.top))\n" +
                "      ||  el.contains(efp(rect.right, rect.bottom))\n" +
                "      ||  el.contains(efp(rect.left,  rect.bottom))\n" +
                "    );\n" +
                "};" +
                "return isElementVisible(arguments[0]);", element);
    }

    public String getTealiumLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Optional<LogEntry> last = (logEntries.getAll().stream().reduce((first, second) -> second));
        return last.toString();
    }

//    public void executeTealiumScript(){
//        evaluateJavascript("$('div[id^=\"analytics-\"]').each(function(){\n" +
//                "       var elementObj = document.getElementById($(this).attr(\"id\"));\n" +
//                "       $.each(getDataAttributes(elementObj), function(item,attrValue){ \n" +
//                "           var positions = [];\n" +
//                "           var finalPageObjectAttr = \"\";\n" +
//                "           positions = item.split(/(?=[A-Z])/);\n" +
//                "           for(var index = 0 ; index < positions.length ; index++){\n" +
//                "               if(index == 0) {\n" +
//                "                   positions[index] = positions[index] + '.';\n" +
//                "               }\n" +
//                "               finalPageObjectAttr+=positions[index];\t\n" +
//                "           }\n" +
//                "           utag_data[finalPageObjectAttr] = attrValue;\n" +
//                "       });\n" +
//                "   });\n" +
//                "   console.log(JSON.stringify(utag_data));\n" +
//                "function getDataAttributes(el) {\n" +
//                "   var data = {};\n" +
//                "   [].forEach.call(el.attributes, function(attr) {\n" +
//                "       if (/^data-/.test(attr.name)) {\n" +
//                "           var camelCaseName = attr.name.substr(5).replace(/-(.)/g, function ($0, $1) {\n" +
//                "               return $1.toUpperCase();\n" +
//                "           });\n" +
//                "           data[camelCaseName] = attr.value;\n" +
//                "       }\n" +
//                "   });\n" +
//                "   return data;\n" +
//                "}\n");
//    }


    public String executeTealiumScript(){
        try {
            Thread.sleep(10000);
        } catch (Exception e){}
        return (String)((JavascriptExecutor) driver).executeScript("return JSON.stringify(utag.utest.track_calls[utag.utest.track_calls.length-1].data)");
//        return (String)evaluateJavascript("return JSON.stringify(utag.utest.track_calls[utag.utest.track_calls.length-1].data)");
    }

    public JSONObject parseJSON(String log){
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) parser.parse(log);
        }
        catch (ParseException e){}
        return json;
    }

}
