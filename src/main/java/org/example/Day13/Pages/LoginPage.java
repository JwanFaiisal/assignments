package org.example.Day13.Pages;

import org.example.Day13.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit")
    public WebElement loginButton;

    @FindBy(id = "signup")
    public WebElement signUpButton;

    public void login(String userEmail, String userPassword) {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        loginButton.click();
    }
}
