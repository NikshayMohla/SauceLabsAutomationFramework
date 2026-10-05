package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HamburgerPage extends BasePage {

    WebDriver driver;

    public HamburgerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav//a[@role='button']")
    List<WebElement> buttons;
    @FindBy(xpath = "//div[@data-test=\"dynamic-catalog-submenu\"]/a")
    List<WebElement> submenu;

    public void clickButton(String buttonName){
        for(WebElement button : buttons){
            if(button.getText().equals(buttonName)){
                button.click();
            }
        }
    }
    public void clickSubButton(String buttonName){
        for(WebElement button : submenu){
            if(button.getText().equals(buttonName)){
                button.click();
            }
        }
    }

}
