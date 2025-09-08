package org.example.Day2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskOne {

    WebDriver driver;

    @BeforeEach
    void beforeEach() {
        System.out.println("Tests are starting to run");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void afterEach() {
        System.out.println("Tests have finished running");
        driver.quit();
    }

    @Test
    void test01() {
        driver.get("https://www.wikipedia.org/");
        String titleWikipedia = driver.getTitle();

        driver.navigate().to("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        // Back to Wikipedia
        driver.navigate().back();
        Assertions.assertEquals(titleWikipedia, driver.getTitle(), "Back navigation failed");

        // Forward to Google
        driver.navigate().forward();
        Assertions.assertEquals(titleGoogle, driver.getTitle(), "Forward navigation failed");
    }

    @Test
    void test02() {
        driver.get("https://www.google.com/");
        String titleBefore = driver.getTitle();

        driver.navigate().refresh();
        String titleAfter = driver.getTitle();

        Assertions.assertTrue(titleAfter.contains("Google"), "Google title missing after refresh");
        Assertions.assertEquals(titleBefore, titleAfter, "Title changed after refresh");
    }
}