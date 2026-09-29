package testCases;

import Models.Products;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.List;

public class TC03_addToCart extends BaseClass {

    @BeforeMethod
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void addToCart() {
        HomePage homePage = new HomePage(driver);
        List<Products> products = homePage.getProducts();

        for (Products p : products) {
            if (p.getProductName().getText().equals("Sauce Labs Bolt T-Shirt")) {
                p.getAddToCartBtn().click();
            } else if (p.getProductName().getText().equals("Test.allTheThings() T-Shirt (Red)")) {
                p.getProductName().click();
                break;
            }
        }

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();

        NavbarPage navbarPage = new NavbarPage(driver);
        navbarPage.clickCartBtn();

        CartPage cartPage = new CartPage(driver);
        List<Products> cartProd = cartPage.getCartList();

        boolean isBoltTShirtInCart = false;
        boolean isAllTheThingsTShirtInCart = false;

        for (Products item : cartProd) {
            if (item.getProductName().getText().equals("Sauce Labs Bolt T-Shirt")) {
                isBoltTShirtInCart = true;
            }
            if (item.getProductName().getText().equals("Test.allTheThings() T-Shirt (Red)")) {
                isAllTheThingsTShirtInCart = true;
            }
        }

        Assert.assertTrue(isBoltTShirtInCart, "Sauce Labs Bolt T-Shirt is missing from cart");
        Assert.assertTrue(isAllTheThingsTShirtInCart, "Test.allTheThings() T-Shirt (Red) is missing from cart");
    }
}