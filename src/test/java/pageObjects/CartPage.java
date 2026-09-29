package pageObjects;

import Models.Products;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public List<Products> getCartList() {
        List<Products> cart = new ArrayList<>();

        for (WebElement product : cartList) {
            WebElement productName = product
                    .findElement(By.cssSelector("[data-test='inventory-item-name']"));

            String productPrice = product.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();

            double finalPrice = Double.parseDouble(productPrice.replace("$", ""));

            String productDesc = product.findElement(By.cssSelector("[data-test='inventory-item-description']")).getText();

            WebElement addToCartBtn = product.findElement(
                    By.cssSelector("button[data-test^='remove']")
            );

            cart.add(new Products(productName, productDesc, finalPrice, addToCartBtn));

        }
        return cart;
    }


}
