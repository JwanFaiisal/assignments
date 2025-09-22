package org.example.Day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task4HardAssertionsPractice {

    private WebDriver driver;
    private final String url = "https://claruswaysda.github.io/signIn.html";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
    }

    @Test(description = "Positive login test with hard assertions")
    public void positiveLoginTest() {
        // 1.
        driver.get(url);

        // 2.
        driver.findElement(By.id("username")).sendKeys("admin");

        // 3.
        driver.findElement(By.id("password")).sendKeys("123");

        // 4.
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // 5.
        String expectedUrl = "https://claruswaysda.github.io/signIn.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,
                "❌ The page URL after login is NOT as expected!");

        boolean containsEmployeeTable = driver.getPageSource().contains("Employee Table");
        Assert.assertTrue(containsEmployeeTable,
                "❌ The page does NOT contain the text 'Employee Table' after login.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
