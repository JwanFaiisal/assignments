package org.example.Day13.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountManagementPage {
    WebDriver driver;
    WebDriverWait wait;

    By customerSelect = By.id("userSelect");
    By currencySelect = By.id("currency");
    By processButton = By.xpath("//button[text()='Process']");

    public AccountManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openAccount(String customerName, String currency) {
        // اختر العميل
        WebElement customerDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(customerSelect));
        Select customerSelectElement = new Select(customerDropdown);
        customerSelectElement.selectByVisibleText(customerName);

        // اختر العملة
        WebElement currencyDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(currencySelect));
        Select currencySelectElement = new Select(currencyDropdown);
        currencySelectElement.selectByVisibleText(currency);

        // اضغط Process
        WebElement processBtn = wait.until(ExpectedConditions.elementToBeClickable(processButton));
        processBtn.click();
    }
}
