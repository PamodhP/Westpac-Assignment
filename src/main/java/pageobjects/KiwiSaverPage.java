package pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class KiwiSaverPage extends BasePage {

    @FindBy(css = ".btn[href='/kiwisaver/calculators/kiwisaver-calculator/']")
    private WebElement btngetStart;

    public KiwiSaverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public KiwiSaverRetirementCalculator navigatetoRetirementCal() {
        click(btngetStart);
        return new KiwiSaverRetirementCalculator(driver);

    }
}
