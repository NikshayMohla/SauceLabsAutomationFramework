package Models;

import lombok.Getter;
import org.openqa.selenium.WebElement;

public class Products {
    public Products(WebElement productName, String productDesc, double finalPrice, WebElement addToCartBtn) {
        this.productName = productName;
        this.description = productDesc;
        this.price = finalPrice;
        this.addToCartBtn = addToCartBtn;
    }

    @Getter
    public WebElement productName;
    @Getter
    public String description;
    @Getter
    public double price;
    @Getter
    public WebElement addToCartBtn;

}
