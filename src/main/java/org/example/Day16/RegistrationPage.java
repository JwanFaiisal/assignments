package org.example.Day16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By ssn = By.id("ssn");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By username = By.id("username");
    private By submit = By.cssSelector("button[type='submit']");
    private By successMessage = By.id("successMessage");
    private By emailError = By.id("emailError");
    private By cvUpload = By.id("cv");
    private By jobSelect = By.id("job");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public RegistrationPage enterSsn(String s) { driver.findElement(ssn).sendKeys(s); return this; }
    public RegistrationPage enterFirstName(String fn) { driver.findElement(firstName).sendKeys(fn); return this; }
    public RegistrationPage enterLastName(String ln) { driver.findElement(lastName).sendKeys(ln); return this; }
    public RegistrationPage enterEmail(String em) { driver.findElement(email).sendKeys(em); return this; }
    public RegistrationPage enterPassword(String pw) { driver.findElement(password).sendKeys(pw); return this; }
    public RegistrationPage enterUsername(String un) { driver.findElement(username).sendKeys(un); return this; }

    public RegistrationPage selectGender(String gender) {
        By genderLocator = By.id(gender); // male, female, other
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(genderLocator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public RegistrationPage selectJob(String jobValue) {
        WebElement jobElement = driver.findElement(jobSelect);
        Select jobDropdown = new Select(jobElement);
        jobDropdown.selectByValue(jobValue);
        return this;
    }

    public RegistrationPage uploadCv(String filePath) {
        driver.findElement(cvUpload).sendKeys(filePath);
        return this;
    }

    public void clickSubmit() { driver.findElement(submit).click(); }

    public String getSuccessMessage() {
        try { return driver.findElement(successMessage).getText(); }
        catch (Exception e) { return ""; }
    }

    public String getEmailError() {
        try { return driver.findElement(emailError).getText(); }
        catch (Exception e) { return ""; }
    }
}
