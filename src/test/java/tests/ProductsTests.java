package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ProductsTests extends BaseTests {

    ProductsPage productsPage;
    String productToSearchFor1 = "Dress";
    String productToSearchFor2 = "Bag";

    @Test(priority = 1)
    public void testSearchFirstProduct() {
        productsPage = new ProductsPage(driver);
        SearchPage searchPage = productsPage.searchProduct(productToSearchFor1);

        Assert.assertTrue(searchPage.isSearchedProductsDisplayed());
    }

    @Test(priority = 2)
    public void testSearchSecondProduct() {
        productsPage = new ProductsPage(driver);
        SearchPage searchPage = productsPage.searchProduct(productToSearchFor2);
        Assert.assertTrue(searchPage.isNoResultMsgDisplayed(), "There is no results related to this search keyword");

    }
}