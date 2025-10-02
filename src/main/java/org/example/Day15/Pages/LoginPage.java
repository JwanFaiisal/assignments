package org.example.Day15.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By usernameInput = By.id("username");
    By emailInput = By.id("email");
    By passwordInput = By.id("password");
    By registerBtn = By.xpath("//button[text()='Register']");
    By loginBtn = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void register(String username, String email, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registerBtn).click();
    }

    public void login(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}