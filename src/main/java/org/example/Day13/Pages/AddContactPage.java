package org.example.Day13.Pages;

import org.example.Day13.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {
    public AddContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "submit")
    public WebElement saveBtn;

    public void addContact(String fName, String lName, String mail) {
        firstName.clear();
        firstName.sendKeys(fName);

        lastName.clear();
        lastName.sendKeys(lName);

        email.clear();
        email.sendKeys(mail);

        saveBtn.click();
    }
}
