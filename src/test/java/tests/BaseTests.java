package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;



public class BaseTests {

    WebDriver driver;

    @BeforeMethod
    public void setup_initiateDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/products");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void a_takeScreenshotForFailedTests(ITestResult result) {
        String destination = "./screenshots/" + result.getName() + ".png";
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                //To add it in the extent report
                FileUtils.copyFile(screenshot, new File(destination));
            } catch (IOException e) {
                // handle
            }
        }
        driver.quit();
    }
}
