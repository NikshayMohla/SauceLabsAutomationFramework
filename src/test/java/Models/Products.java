package Models;

import lombok.Getter;

public class Products {
    public Products(String productName, String productDesc, double finalPrice) {
        this.productName = productName;
        this.description = productDesc;
        this.price = finalPrice;
    }

    @Getter
    public String productName;
    @Getter
    public String description;
    @Getter
    public double price;

}
