package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartTests extends BaseTests
{

    CartPage cartPage;
    @Test

    public void testAddToCartFunctionality ()
    {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage = productsPage.clickContinueShoppingBtn() ;
        productsPage.addSecondProductToCart();
        CartPage cartPage = productsPage.clickViewCartButton ();
        Assert.assertEquals(cartPage.getSizeOfAddedProducts(), 2, "The added products should be 2");
        Assert.assertEquals(cartPage.getFirstProductPrice(), "Rs. 500", "The price should be Rs. 500");
    }

    }
