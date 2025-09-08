package org.example.Day2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskThree {

    WebDriver driver;
    String url = "https://www.google.com";

    @BeforeEach
    void beforeEach() {
        System.out.println("Tests are starting to run");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Tests have finished running");
        driver.quit();
    }

    @Test
    void test01() {
        String titleMaximized = driver.getTitle();

        // نغير حجم النافذة لمحاكاة التصغير (لأن minimize ما يشتغل في كل مكان)
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(400, 300));
        String titleMinimized = driver.getTitle();

        Assertions.assertEquals(titleMaximized, titleMinimized, "Titles are not the same when window is resized");
    }

    @Test
    void test02() {
        driver.manage().window().fullscreen();
        String title = driver.getTitle();

        Assertions.assertFalse(title.toLowerCase().contains("video"), "Title contains the word 'Video'");
    }

    @Test
    void test03() {
        String currentUrl = driver.getCurrentUrl();

        Assertions.assertTrue(currentUrl.toLowerCase().contains("google"), "URL does not contain 'google'");
    }
}