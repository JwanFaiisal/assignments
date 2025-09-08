package org.example.Day2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskTwo {

    WebDriver driver;

    @BeforeEach
    void beforeEach() {
        System.out.println("Test is running");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test finished");
        driver.quit();
    }

    // Test 1: Verify Selenium page source contains "WebDriver"
    @Test
    void test01() {
        System.out.println("Test 1");

        driver.get("https://www.selenium.dev/");
        Assertions.assertTrue(driver.getPageSource().contains("WebDriver"));
    }

    @Test
    void test02() {
        System.out.println("Test 2");

        driver.get("https://www.python.org/");
        Assertions.assertTrue(driver.getPageSource().contains("Python"));
    }
}