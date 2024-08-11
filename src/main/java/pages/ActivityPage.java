package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ActivityPage extends BasePage{
    public ActivityPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }
}
