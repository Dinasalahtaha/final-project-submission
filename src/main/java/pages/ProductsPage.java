package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    //locators

    private By searchInputField = By.name("search");
    private By searchBtn = By.id("submit_search");

    private By firstProduct = By.xpath("(//div[@class= 'productinfo text-center'])[1]");
    private By addToCartBtnOfFirstProduct = By.xpath("(//div[@class='productinfo text-center']/a)[1]");

    private By secondProduct = By.xpath("(//div[@class='productinfo text-center'])[2]");
    private By addToCartBtnOfSecondProduct = By.xpath("(//div[@class='productinfo text-center']/a)[2]");

    private By continueShoppingBtn = By.xpath("//button[contains(@class,'close-modal')]");
    private By viewCartBtn = By.xpath("//div[@class='modal-body']//a");

    //operations
    public SearchPage searchProduct(String productName) {
        typeOnInputField(searchInputField, productName);
        clickOnElement(searchBtn);
        return new SearchPage(driver);
    }
    public void addFirstProductToCart()
    {
        scrollVertically(700);
        hoverOverElement(firstProduct);
        forceClickOnElement(addToCartBtnOfFirstProduct);
    }

    public void addSecondProductToCart()
    {
        hoverOverElement(secondProduct);
        forceClickOnElement(addToCartBtnOfSecondProduct);

    }

    public ProductsPage clickContinueShoppingBtn() {
        clickElement(continueShoppingBtn);
        return new ProductsPage(driver);
    }

    public CartPage clickViewCartButton() {
        clickElement(viewCartBtn);
        return new CartPage(driver);
    }
}
