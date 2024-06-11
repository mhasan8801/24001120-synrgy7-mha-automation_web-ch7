package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Backpack')]")
    WebElement sauceLabsBackpack;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Bike Light')]")
    WebElement sauceLabsBikeLight;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(xpath = "//img[@alt='Pony Express']")
    WebElement completeImage;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement thankYouForYourOrderLabel;

    @FindBy(xpath = "//div[@class='complete-text']")
    WebElement yourOrderHasBeenDispatchedLabel;

    public CheckoutPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyListProductDisplayedOnCart(){
        sauceLabsBackpack.isDisplayed();
        sauceLabsBikeLight.isDisplayed();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void inputFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void inputZipPostalCode(String postalCode){
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public void verifyCheckoutComplete(){
        Assert.assertTrue(checkoutComplete());
    }

    public boolean checkoutComplete(){
        completeImage.isDisplayed();
        thankYouForYourOrderLabel.isDisplayed();
        yourOrderHasBeenDispatchedLabel.isDisplayed();
        return true;
    }

}
