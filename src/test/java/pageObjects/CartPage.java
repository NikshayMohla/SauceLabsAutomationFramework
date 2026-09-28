package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"cart_item\"]")
    List<WebElement> cartList;

    @FindBy(xpath = "//button[@data-test='checkout']")
    WebElement checkoutButton;


}
