package org.example.Day13.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerManagementPage {
    WebDriver driver;
    WebDriverWait wait;

    public CustomerManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement postCodeField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addCustomerBtn;

    public void addCustomer(String firstName, String lastName, String postCode) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).clear();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
        addCustomerBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

