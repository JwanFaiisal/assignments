package org.example.Day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public class C02SecondAssingment {

    WebDriver driver;

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

    @Test
    void assignmentTask() {
        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println("URL after back: " + driver.getCurrentUrl());

        driver.findElement(By.linkText("WebDriver Example Page")).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.findElement(By.id("numentry")).sendKeys("20");
        driver.findElement(By.id("submit-to-server")).click();

        WebElement message = driver.findElement(By.id("message"));
        String actualText = message.getText();

        Assertions.assertTrue(actualText.contains("two, zero"),
                "Expected message to contain 'two, zero' but got: " + actualText);

        System.out.println("✅ Message verification PASSED: " + actualText);
    }
}
