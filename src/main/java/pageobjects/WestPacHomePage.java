package pageobjects;

import base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class WestPacHomePage extends BasePage {

    private Logger logger = Logger.getLogger(WestPacHomePage.class);

    @FindBy(css = "#ubermenu-section-link-kiwisaver-ps")
    private WebElement lnkKiwiSavar;

    @FindBy(css = "#ubermenu-item-cta-kiwisaver-calculators-ps")
    private WebElement btnKiwiSaverCal;

    public WestPacHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public KiwiSaverPage navigateKiwisaver() {
        click(lnkKiwiSavar);
        logger.info("Navigate to the Westpac KiwiSaver page");
        click(btnKiwiSaverCal);
        return new KiwiSaverPage(driver);
    }
}
