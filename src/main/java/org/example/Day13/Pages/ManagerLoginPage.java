package org.example.Day13.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    private WebElement managerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    private WebElement openAccountButton;

    public ManagerLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void loginAsManager() {
        wait.until(ExpectedConditions.elementToBeClickable(managerLoginButton)).click();
    }

    public void navigateToAddCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton)).click();
    }

    public void navigateToOpenAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton)).click();
    }
}
