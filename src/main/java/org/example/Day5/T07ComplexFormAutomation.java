package org.example.Day5;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T07ComplexFormAutomation {

    WebDriver driver;
    WebDriverWait wait;
    Faker faker;

    @BeforeEach
    void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
    }

    @Test
    void completeFormAutomation() {
        driver.get("https://demoqa.com/automation-practice-form");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String mobile = faker.number().digits(10);
        String address = faker.address().fullAddress();

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);

        WebElement genderMale = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderMale);
        driver.findElement(By.id("userNumber")).sendKeys(mobile);

        WebElement hobbyReading = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbyReading);

        driver.findElement(By.id("currentAddress")).sendKeys(address);

        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        WebElement modalContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        System.out.println("Modal title: " + modalContent.getText());
        assert modalContent.getText().contains("Thanks");
    }

    @AfterEach
    void afterEach() {
        if (driver != null) {
            driver.quit();
        }
    }
}
