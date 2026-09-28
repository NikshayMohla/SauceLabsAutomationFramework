package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarPage extends BasePage {

    WebDriver driver;

    public NavbarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-test=\"shopping-cart-link\"]")
    WebElement cartBtn;

    @FindBy(xpath = "//button[@id=\"react-burger-menu-btn\"]")
    WebElement hamburgerBtn;

    public void clickCartBtn() {
        cartBtn.click();
    }

    public void clickHamburgerBtn() {
        hamburgerBtn.click();
    }

}
