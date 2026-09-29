package pageObjects;

import Models.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-test='inventory-item']")
    List<WebElement> inventoryList;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    WebElement productSort;

    @FindBy(css = "[data-test='inventory-item-name']")
    List<WebElement> productNameList;


    public void selectSort(String option) {
        Select select = new Select(productSort);
        select.selectByValue(option);
    }

    public List<Products> getProducts() {
        List<Products> products = new ArrayList<>();

        for (WebElement product : inventoryList) {
            WebElement productName = product
                    .findElement(By.cssSelector("[data-test='inventory-item-name']"));

            String productPrice = product.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();

            double finalPrice = Double.parseDouble(productPrice.replace("$", ""));

            String productDesc = product.findElement(By.cssSelector("[data-test='inventory-item-description']")).getText();

            WebElement addToCartBtn = product.findElement(
                    By.cssSelector("button[data-test^='add-to-cart']")
            );

            products.add(new Products(productName, productDesc, finalPrice, addToCartBtn));

        }
        return products;
    }

    public void clickCard(String title) {
        for (WebElement product : productNameList) {
            if (product.getText().equals(title)) {
                product.click();
                break;
            }
        }
    }

}
