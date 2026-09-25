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

    public void selectSort(String option) {
        Select select = new Select(productSort);
        select.selectByValue(option);
    }

    public List<Products> getProducts() {
        List<Products> products = new ArrayList<>();

        for (WebElement product : inventoryList) {
            String productName = product
                    .findElement(By.cssSelector("[data-test='inventory-item-name']"))
                    .getText();

            String productPrice = product.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();

            double finalPrice = Double.parseDouble(productPrice.replace("$", ""));

            String productDesc = product.findElement(By.cssSelector("[data-test='inventory-item-description']")).getText();

            products.add(new Products(productName, productDesc, finalPrice));

        }
        return products;
    }

}
