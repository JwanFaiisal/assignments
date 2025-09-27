package org.example.Day13.Pages;

import org.example.Day13.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit")
    public WebElement submitButton;

    public void signUp(String fName, String lName, String mail, String pass) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        password.sendKeys(pass);
        submitButton.click();
    }
}
