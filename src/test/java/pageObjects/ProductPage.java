package pageObjects;

import Models.Products;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-test=\"inventory-item-name\"]")
    WebElement productName;

    @FindBy(xpath = "//div[@data-test=\"inventory-item-desc\"]")
    WebElement productDescription;

    @FindBy(xpath = "//div[@data-test=\"inventory-item-price\"]")
    WebElement productPrice;

    @FindBy(xpath = "//button[@data-test=\"add-to-cart\"]")
    WebElement addToCartButton;


    public Products getProduct() {
        WebElement name = productName;
        String description = productDescription.getText();
        double price = Double.parseDouble(
                productPrice.getText().replace("$", "")
        );
        return new Products(name, description, price, addToCartButton);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

}
