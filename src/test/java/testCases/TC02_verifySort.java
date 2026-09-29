package testCases;

import Models.Products;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TC02_verifySort extends BaseClass {

    @DataProvider(name = "sortOptions")
    public Object[][] sortOptions() {
        return new Object[][]{
                {"az"}, {"za"}, {"hilo"}, {"lohi"}
        };
    }

    @BeforeMethod
    public void loginBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(dataProvider = "sortOptions")
    public void verifySort(String sort) {
        HomePage homePage = new HomePage(driver);
        List<Products> allProducts = homePage.getProducts();

        List<String> expectedNames = new ArrayList<>();
        List<Double> expectedPrices = new ArrayList<>();

        for (Products product : allProducts) {
            expectedNames.add(product.getProductName().getText());
            expectedPrices.add(product.getPrice());
        }

        homePage.selectSort(sort);
        List<Products> sortedProducts = homePage.getProducts();

        List<String> actualNames = new ArrayList<>();
        List<Double> actualPrices = new ArrayList<>();

        for (Products product : sortedProducts) {
            // Extract the actual text from the WebElement here
            actualNames.add(product.getProductName().getText());
            actualPrices.add(product.getPrice());
        }

        List<String> sortedExpectedNames = new ArrayList<>(expectedNames);
        List<Double> sortedExpectedPrices = new ArrayList<>(expectedPrices);

        switch (sort) {
            case "az":
                Collections.sort(sortedExpectedNames);
                Assert.assertEquals(actualNames, sortedExpectedNames, "Products are not sorted A to Z");
                break;
            case "za":
                Collections.sort(sortedExpectedNames, Collections.reverseOrder());
                Assert.assertEquals(actualNames, sortedExpectedNames, "Products are not sorted Z to A");
                break;
            case "lohi":
                Collections.sort(sortedExpectedPrices);
                Assert.assertEquals(actualPrices, sortedExpectedPrices, "Products are not sorted from low to high");
                break;
            case "hilo":
                Collections.sort(sortedExpectedPrices, Collections.reverseOrder());
                Assert.assertEquals(actualPrices, sortedExpectedPrices, "Products are not sorted from high to low");
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting option: " + sort);
        }
    }
}