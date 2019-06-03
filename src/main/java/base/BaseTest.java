package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.BrowserFactory;
import utils.ConfigPropertyRead;

import java.io.File;
import java.io.IOException;


public class BaseTest extends Base {

    public SoftAssert sAssert;
    private Logger logger = Logger.getLogger(BaseTest.class);
    private String browser;
    private String baseUrl;

    {
        try {
            browser = ConfigPropertyRead.readproperty().get("browser").toString();
            baseUrl = ConfigPropertyRead.readproperty().get("url").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void getDriver() {

        try {
            browserLaunch();
            logger.info("The URL " + baseUrl + " Open in " + browser + " Browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will return the browser according to the configuration
     *
     * @return
     * @throws IOException
     */

    public WebDriver browserLaunch() throws IOException {

        if (browser.equals("firefox")) {
            driver = BrowserFactory.getDriver("firefox");
        } else if (browser.equals("chrome")) {
            driver = BrowserFactory.getDriver("chrome");
        } else {
            driver = BrowserFactory.getDriver("default");
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    /**
     * This method will quite the driver and capture a screen shot if there is any failure- save in target/logs/
     *
     * @param result
     */
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                FileHandler.copy(screenshot.getScreenshotAs(OutputType.FILE), new File("./target/logs/" + result.getName() + ".png"));
                logger.info("Successfully captured a screenshot");
            } catch (Exception e) {
                logger.info("Exception while taking screen shot " + e.getMessage());
            }
        }
        driver.quit();
    }
}
