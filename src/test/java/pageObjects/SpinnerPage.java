package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SpinnerPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public SpinnerPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//div[@class=\"dynamic_catalog_spinner_grid\"]")
    WebElement grid;
    @FindBy(xpath = "//div[@class=\"dynamic_catalog_card\"]")
    List<WebElement> spinnerItems;

    public List<WebElement> getGrid(){
        wait.until(ExpectedConditions.visibilityOf(grid));
        return spinnerItems;
    }

}
