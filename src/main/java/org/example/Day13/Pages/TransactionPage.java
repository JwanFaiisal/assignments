package org.example.Day13.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransactionPage {
    WebDriver driver;
    WebDriverWait wait;

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    private WebElement depositTab;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    private WebElement withdrawTab;

    @FindBy(xpath = "//input[@ng-model='amount']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement confirmBtn;

    @FindBy(xpath = "//strong[2]")
    private WebElement balanceText;

    public void deposit(int amount) {
        wait.until(ExpectedConditions.elementToBeClickable(depositTab)).click();
        wait.until(ExpectedConditions.visibilityOf(amountInput)).clear();
        amountInput.sendKeys(String.valueOf(amount));
        confirmBtn.click();
    }

    public void withdraw(int amount) {
        wait.until(ExpectedConditions.elementToBeClickable(withdrawTab)).click();
        wait.until(ExpectedConditions.visibilityOf(amountInput)).clear();
        amountInput.sendKeys(String.valueOf(amount));
        confirmBtn.click();
    }

    public int getBalance() {
        wait.until(ExpectedConditions.visibilityOf(balanceText));
        return Integer.parseInt(balanceText.getText());
    }
}
