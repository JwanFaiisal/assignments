package org.example.Day6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1WindowHandlePractice {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testWindowHandle() {
        // 1.
        driver.get("https://claruswaysda.github.io/");

        // 2.
        driver.findElement(By.linkText("Window Handle")).click();

        // 3.
        String mainWindow = driver.getWindowHandle();

        // 4.
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // 5.
        driver.findElement(By.id("openIndex")).click();

    }
}
