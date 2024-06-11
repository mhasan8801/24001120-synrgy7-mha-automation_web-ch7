package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginFailed {

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

        loginPage.openLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce123");
        loginPage.clickLoginButton();
        loginPage.verifyLoginFailed();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
