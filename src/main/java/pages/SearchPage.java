package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By searchProduct = By.cssSelector(".features_items>h2");
    By allSearchProducts = By.xpath("//div[@class= 'product-overlay']");

    //operations
    public boolean isSearchedProductsDisplayed() {
        return isElementDisplayedOnPage(searchProduct);

    }

//    public int listOfAllSearchProducts() {
//        return locateListOfElements(allSearchProducts).size();

//    }

    public boolean isNoResultMsgDisplayed() {
        return isElementDisplayedOnPage(searchProduct);

    }
}