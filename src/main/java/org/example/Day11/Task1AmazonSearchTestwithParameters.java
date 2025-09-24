package org.example.Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Task1AmazonSearchTestwithParameters {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Parameters("searchKeyword")
    @Test
    public void amazonSearchTest(String keyword) {
        driver.get("https://www.amazon.com/?language=en_US");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // حاول تضغط على زر "Continue shopping" إذا ظهر
        try {
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Continue shopping')]")
            ));
            continueBtn.click();
            System.out.println("Clicked Continue shopping button.");
        } catch (Exception e) {
            System.out.println("No Continue shopping popup appeared.");
        }

        // انتظر لحد ما يظهر مربع البحث
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        // اكتب الكلمة واضغط زر البحث
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        driver.findElement(By.id("nav-search-submit-button")).click();

        // تحقق من وجود الكلمة في النتائج
        String pageSource = driver.getPageSource().toLowerCase();
        Assert.assertTrue(pageSource.contains(keyword.toLowerCase()),
                "Search results should contain: " + keyword);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
