package org.example.Day2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskFour {

    static WebDriver driver;

    @BeforeEach
    void beforeEach() {
        System.out.println("Tests are starting to run");
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tests have finished running");
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void teat01() {
        driver.get("https://www.google.com/");
        String googleTitle = driver.getTitle();
        Assertions.assertTrue(googleTitle.contains("Google"));

        driver.navigate().to("https://www.youtube.com/");
        String youtubeTitle = driver.getTitle();
        Assertions.assertTrue(youtubeTitle.contains("YouTube"));

        driver.navigate().to("https://www.linkedin.com/");
        String linkedinTitle = driver.getTitle();
        Assertions.assertTrue(linkedinTitle.contains("LinkedIn"));
    }

    @Test
    void test02() {
        driver.get("https://www.google.com/");
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().to("https://www.linkedin.com/");

        driver.navigate().back(); // from LinkedIn to YouTube
        driver.navigate().back(); // from YouTube to Google

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("google"), "Not back to Google");

        driver.navigate().forward(); // to YouTube
        driver.navigate().forward(); // to LinkedIn

        String finalUrl = driver.getCurrentUrl();
        Assertions.assertTrue(finalUrl.contains("linkedin"), "Not forward to LinkedIn");
    }
}
