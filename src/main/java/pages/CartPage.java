package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By allCartRows = By.xpath("//tr[contains(@id,'product-')]");
    By firstProductPrice = By.xpath("//tr[@id='product-1']/td[@class='cart_price']");

    public int getSizeOfAddedProducts()
    {
        return locateListOfElement(allCartRows).size();
    }

    public String getFirstProductPrice()
    {
        return getTextOfElement(firstProductPrice);
    }
}