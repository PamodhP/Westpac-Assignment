package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends Base {

    /**
     * This method will return true if the give element is displayed
     *
     * @param element
     * @return boolean
     */
    boolean isDisplayed = false;
    private Logger logger = Logger.getLogger(BasePage.class);

    /**
     * This is a wrapper method to send keys to element
     *
     * @param element
     * @param text
     */
    protected void sendKeys(WebElement element, String text) {
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            logger.error("sendKeys(element, " + text + ") failed with error : " + e.getMessage());
        }
    }

    /**
     * This is a wrapper method to click on the given element
     *
     * @param element
     */
    protected void click(WebElement element) {
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
            } else {
                sleep(3);
                element.click();
            }
        } catch (NoSuchElementException f) {
            logger.error("Element not visible in screen : " + f.getMessage());
        }
    }

    /**
     * This is method to set hard wait
     *
     * @param seconds
     */
    protected void sleep(double seconds) {
        try {
            logger.info("Sleeping for " + seconds + " seconds...");
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }

    /**
     * This method use for navigate to a iframe
     */
    public void navigateIframe() {
        sleep(3);
        WebElement iFrame = driver.findElement(By.xpath("//div[@id='calculator-embed']//iframe"));
        driver.switchTo().frame(iFrame);
    }

    /**
     * This method is waiting to locate to the locator until its visible
     *
     * @param locator
     * @param timeOutInSeconds
     */
    protected void waitforVisibility(By locator, Integer timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("Unable to locate to the locator : " + locator);
        }
    }

    protected boolean verifyAvailability(WebElement element, String elemnetName) {

        if (element.isDisplayed()) {
            logger.info("Element : " + elemnetName + " is Displayed " + element);
            return isDisplayed = true;
        } else {
            logger.error("Element : " + elemnetName + " is not Displayed " + element);
            return isDisplayed = false;
        }
    }
}
