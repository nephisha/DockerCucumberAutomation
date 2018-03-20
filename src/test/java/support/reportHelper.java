package support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class reportHelper {

    private WebDriver driver;

    public reportHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    public String createReportDirectory(String dirName) {
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_YYYY");
        Calendar calendar = Calendar.getInstance();

        File directory = new File(System.getProperty("user.dir") +"/reports/screenshots/" +
                dateFormat.format(new Date()).toString() + "/" + dirName);

        if (!directory.exists()) {
            directory.mkdir();
        }

        return directory.getPath().toString();
    }

    public String capture(String screenShotName) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_YYYY");
        Calendar calendar = Calendar.getInstance();

        TakesScreenshot ts = (TakesScreenshot)  this.driver ;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenShotDestination =
                "reports\\screenshots\\" + dateFormat.format(new Date()).toString() + "\\"
                        + screenShotName + ".png";

        File destination = new File(screenShotDestination);
        FileUtils.copyFile(source, destination);

        return screenShotDestination;
    }
}
