package org.example.Day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5FormHandlingwithJavaScriptExecutor {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //  لعمل flash للعنصر
    public void flashElement(WebElement element) {
        String originalColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 3; i++) {
            js.executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
            sleep(200);
            js.executeScript("arguments[0].style.backgroundColor = arguments[1]", element, originalColor);
            sleep(200);
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void registerUserAndLogin() {
        driver.get("https://claruswaysda.github.io/form.html");

        WebElement ssn = driver.findElement(By.id("ssn"));
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement phone = driver.findElement(By.id("phone"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
        WebElement registerBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        flashElement(ssn); ssn.sendKeys("123-45-6789");
        flashElement(firstName); firstName.sendKeys("John");
        flashElement(lastName); lastName.sendKeys("Doe");
        flashElement(address); address.sendKeys("123 Street");
        flashElement(phone); phone.sendKeys("5551234567");
        flashElement(username); username.sendKeys("johndoe");
        flashElement(email); email.sendKeys("johndoe@example.com");
        flashElement(password); password.sendKeys("Password123");
        flashElement(confirmPassword); confirmPassword.sendKeys("Password123");

        flashElement(registerBtn); registerBtn.click();

        WebElement successMsg = driver.findElement(By.id("successMessage"));
        flashElement(successMsg);

        WebElement loginBtn = successMsg.findElement(By.className("login-button"));
        flashElement(loginBtn);
        loginBtn.click();
    }
}
