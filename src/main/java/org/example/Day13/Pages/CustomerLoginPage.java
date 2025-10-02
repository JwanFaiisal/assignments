package org.example.Day13.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CustomerLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By customerSelect = By.id("userSelect");
    By loginButton = By.xpath("//button[text()='Login']");

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginAsCustomer(String customerName) {
        // 1. اختر العميل من الـ dropdown
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(customerSelect));
        Select customerDropdown = new Select(dropdownElement);
        customerDropdown.selectByVisibleText(customerName);

        // 2. انتظر حتى يظهر زر Login ثم اضغط عليه
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}
