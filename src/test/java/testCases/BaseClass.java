package testCases;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.apache.logging.log4j.*;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public Logger logger;

    @BeforeMethod
    public void setup() {
        logger=  LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
