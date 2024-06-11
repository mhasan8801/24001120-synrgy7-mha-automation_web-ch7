package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {

    WebDriver driver;

    @FindBy(css = "title")
    WebElement productPageTitle;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Backpack')]")
    WebElement sauceLabsBackpack;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Bike Light')]")
    WebElement sauceLabsBikeLight;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortingButton;

    @FindBy(xpath = "//option[@value='hilo']")
    WebElement highToLowPrice;

    @FindBy(css = ".inventory_list > div:nth-of-type(1) .inventory_item_price")
    WebElement firstPriceAfterSorted;

    @FindBy(css = ".inventory_list > div:nth-of-type(2) .inventory_item_price")
    WebElement secondPriceAfterSorted;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCardProduct1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCardProduct2;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cardButton;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyLoginSuccess(){
        productPageTitle.isDisplayed();
        sauceLabsBackpack.isDisplayed();
        sauceLabsBikeLight.isDisplayed();
    }

    public void clickSortingButton(){
        sortingButton.click();
    }

    public void clickHighToLowPrice(){
        highToLowPrice.click();
    }

    public void verifySortingHighToLow(){
        Assert.assertTrue(sortingHighToLow());
    }

    public boolean sortingHighToLow(){
        var price1String = firstPriceAfterSorted.getText();
        var price2String = secondPriceAfterSorted.getText();

        double price1 = Double.parseDouble(price1String.replace("$", ""));
        double price2 = Double.parseDouble(price2String.replace("$", ""));
        System.out.println(price1);
        System.out.println(price2);

        return price1 > price2;
    }

    public void addProduct1ToCard(){
        addToCardProduct1.click();
    }

    public void addProduct2ToCard(){
        addToCardProduct2.click();
    }

    public void clickCardButton(){
        cardButton.click();
    }

}
