package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ActivityPage extends BasePage{
    public ActivityPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//div[@class='phenom-desc']")
    WebElement firstElementActivities;

    public boolean isTextFirstElementActivitiesPresent(){
        return isTextInElementPresent(firstElementActivities, " closed ", 3);
    }
}
