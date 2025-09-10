package org.example.Day3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T06AdvancedCaptchaHandling {

    WebDriver driver;

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

    @Test
    void solveCaptcha() {

        driver.get("https://form.jotform.com/73302671092956");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframe);
        } catch (Exception e) {
            System.out.println("No iframe found, continuing...");
        }
        WebElement number1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
        WebElement operatorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("function")));
        WebElement number2Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number2")));
        WebElement resultInput = driver.findElement(By.id("result"));

        int num1 = Integer.parseInt(number1Element.getText());
        int num2 = Integer.parseInt(number2Element.getText());
        String operator = operatorElement.getText().trim();

        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Division by zero! Setting result to 0");
                    result = 0;
                } else {
                    result = Math.round((float) num1 / num2);
                }
                break;
            default:
                System.out.println("Unknown operator: " + operator);
        }

        resultInput.sendKeys(String.valueOf(result));

        System.out.println("Captcha solved: " + num1 + " " + operator + " " + num2 + " = " + result);
    }
}
