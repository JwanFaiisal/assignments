package org.example.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class Task4RobotNavigation {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.click();
        usernameField.sendKeys("tomsmith");

        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
        robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
        Thread.sleep(500);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        Thread.sleep(500);

        WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flashMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );

        String message = flashMessage.getText();
        System.out.println("Message: " + message);

        if (message.contains("You logged into a secure area!")) {
            System.out.println("Login successful!");
        } else if (message.contains("Your username is invalid!") ||
                message.contains("Your password is invalid!")) {
            System.out.println("Login failed!");
        } else {
            System.out.println("Unknown message appeared!");
        }


        driver.quit();
    }
}
