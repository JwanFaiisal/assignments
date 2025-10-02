package org.example.Day13.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[@ng-click='manager()']")
    private WebElement managerLoginBtn;

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    private WebElement addCustomerTab;

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    private WebElement openAccountTab;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    private WebElement customersTab;

    @FindBy(id = "userSelect")
    private WebElement customerSelect;

    @FindBy(id = "currency")
    private WebElement currencySelect;

    public ManagerLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // تسجيل الدخول كمدير
    public void loginAsManager() {
        wait.until(ExpectedConditions.elementToBeClickable(managerLoginBtn)).click();
    }

    public void goToAddCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerTab)).click();
    }

    public void goToOpenAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountTab)).click();
    }

    public void goToCustomers() {
        wait.until(ExpectedConditions.elementToBeClickable(customersTab)).click();
    }

    // اختيار العميل من القائمة
    public void selectCustomer(String customerName) {
        wait.until(ExpectedConditions.elementToBeClickable(customerSelect)).click();
        WebElement option = customerSelect.findElement(By.xpath(".//option[text()='" + customerName + "']"));
        option.click();
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }

    // اختيار العملة من القائمة
    public void selectCurrency(String currency) {
        wait.until(ExpectedConditions.elementToBeClickable(currencySelect)).click();
        WebElement option = currencySelect.findElement(By.xpath(".//option[text()='" + currency + "']"));
        option.click();
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }

    // الضغط على Process والتعامل مع alert
    public void processAccount() {
        WebElement processBtn = driver.findElement(By.xpath("//button[@type='submit' and text()='Process']"));
        processBtn.click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();  // اغلق الـ alert
            System.out.println("Alert accepted successfully");
        } catch (Exception e) {
            System.out.println("No alert appeared after clicking Process");
        }
    }
}
