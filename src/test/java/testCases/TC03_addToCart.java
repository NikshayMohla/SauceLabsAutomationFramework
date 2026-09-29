package testCases;

import Models.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC03_addToCart {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void addToCart()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(driver);
        List<Products> products = homePage.getProducts();
        for (Products p : products) {
//            System.out.println(p.getProductName().getText());
            if (p.getProductName().getText().equals("Sauce Labs Bolt T-Shirt")) {
                p.getAddToCartBtn().click();
                continue;
            }
            if (p.getProductName().getText().equals("Test.allTheThings() T-Shirt (Red)")) {
                p.getProductName().click();
            }

        }
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        NavbarPage navbarPage = new NavbarPage(driver);
        navbarPage.clickCartBtn();
        CartPage cartPage = new CartPage(driver);
        List<Products> cartProd =cartPage.getCartList();
        boolean isItemInCart = false;

        for (Products item : cartProd) {
            // Note: This relies on the Model fix in step 2 below
            if (item.getProductName().getText().equals("Sauce Labs Bolt T-Shirt") ){
                isItemInCart = true;
                break;
            }
        }

        Assert.assertTrue(isItemInCart, "The Sauce Labs Bolt T-Shirt was not found in the cart!");

    }


    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

}
