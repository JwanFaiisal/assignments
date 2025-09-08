package org.example.Day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01fistAssignment {

    WebDriver driver;

    // Relative XPaths
    String relativeUsernameXPath = "//input[@name='username']";
    String relativePasswordXPath = "//input[@name='password']";
    String relativeLoginButtonXPath = "//button[@type='submit']";

    // Absolute XPaths
    String absoluteUsernameXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/input";
    String absolutePasswordXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
    String absoluteLoginButtonXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void relativeXpathTest() {
        WebElement usernameField = driver.findElement(By.xpath(relativeUsernameXPath));
        WebElement passwordField = driver.findElement(By.xpath(relativePasswordXPath));
        WebElement loginButton = driver.findElement(By.xpath(relativeLoginButtonXPath));

        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();
    }

    @Test
    void absoluteXpathTest() {
        WebElement usernameField = driver.findElement(By.xpath(absoluteUsernameXPath));
        WebElement passwordField = driver.findElement(By.xpath(absolutePasswordXPath));
        WebElement loginButton = driver.findElement(By.xpath(absoluteLoginButtonXPath));

        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();
    }
}
