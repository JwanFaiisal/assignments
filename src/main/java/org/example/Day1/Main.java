package org.example.Day1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        // 1.
        WebDriver driver = new ChromeDriver();

        // 2.
        driver.navigate().to("https://www.google.com");

        // 3.
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // 4.
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // 5.
        driver.quit();


    }
}