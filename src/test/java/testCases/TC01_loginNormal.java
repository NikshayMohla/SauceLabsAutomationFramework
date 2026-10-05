package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC01_loginNormal extends BaseClass {
    @Test
    public void loginNormal() {
        logger.info("Start TC01_loginNormal");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

    }

    @Test
    public void loginWrongPassword() {
        logger.info("Start TC01_loginWrongPassword");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "password");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void loginEmptyUserNamePassword() {
        logger.info("Start TC01_loginEmptyUserNamePassword");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username is required");

    }

    @Test
    public void loginEmptyPassword() {
        try {
            logger.info("Start TC01_loginEmptyPassword");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "");
            String error = loginPage.getErrorMessage();
            Assert.assertEquals(error, "Epic sadface: Password is required");
        } catch (Exception e) {
            logger.error("Exception occurred while trying to login", e);
            logger.debug("Exception occurred while trying to login");
        }
    }

    @Test
    public void loginEmptyUsername() {
        logger.info("Start TC01_loginEmptyUsername");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "password");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username is required");

    }

    @Test
    public void loginLockedUser() {
        logger.info("Start TC01_loginLockedUser");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Sorry, this user has been locked out.");

    }
}
