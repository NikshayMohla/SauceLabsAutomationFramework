package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
