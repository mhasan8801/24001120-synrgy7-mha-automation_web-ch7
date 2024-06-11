package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductPage;

public class SortHighToLow {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void test_simple(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.openLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        productPage.verifyLoginSuccess();
        productPage.clickSortingButton();
        productPage.clickHighToLowPrice();
        productPage.verifySortingHighToLow();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
