package org.example.Day13.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class AccountManagementPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "userSelect")
    private WebElement customerSelect;

    @FindBy(id = "currency")
    private WebElement currencySelect;

    @FindBy(xpath = "//button[text()='Process']")
    private WebElement processButton;

    public AccountManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openAccount(String customerName, String currency) {
        Select customerDropdown = new Select(wait.until(ExpectedConditions.visibilityOf(customerSelect)));
        customerDropdown.selectByVisibleText(customerName);

        Select currencyDropdown = new Select(wait.until(ExpectedConditions.visibilityOf(currencySelect)));
        currencyDropdown.selectByVisibleText(currency);

        processButton.click();
        handleExistingAlerts();
    }

    private void handleExistingAlerts() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present, continue normally");
        }
    }
}
