package org.example.Day18.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "signup")
    WebElement signUpLink;

    @FindBy(id = "firstName")
    WebElement firstNameInput;

    @FindBy(id = "lastName")
    WebElement lastNameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    public SignUpPage openPage() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        return this;
    }

    public SignUpPage createAccount(String first, String last, String email, String password) {
        signUpLink.click();
        firstNameInput.sendKeys(first);
        lastNameInput.sendKeys(last);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return this;
    }
}
