package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC01_loginNormal extends BaseClass {
    @Test
    public void loginNormal() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

    }

    @Test
    public void loginWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "password");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void loginEmptyUserNamePassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username is required");

    }

    @Test
    public void loginEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Password is required");

    }

    @Test
    public void loginEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "password");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username is required");

    }
    @Test
    public void loginLockedUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Sorry, this user has been locked out.");

    }
}
