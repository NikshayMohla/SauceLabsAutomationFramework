package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"user-name\"]")
    WebElement userName;
    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement password;
    @FindBy(xpath = "//input[@id=\"login-button\"]")
    WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    WebElement error;

    void setUserName(String username) {
        userName.sendKeys(username);
    }

    void setPassword(String password1) {
        password.sendKeys(password1);
    }

    void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        setUserName(username);
        setPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return error.getText();
    }

}
