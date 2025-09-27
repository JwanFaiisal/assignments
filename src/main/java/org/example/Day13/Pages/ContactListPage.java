package org.example.Day13.Pages;

import org.example.Day13.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactListPage {
    public ContactListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "add-contact")
    public WebElement addContactBtn;

    @FindBy(xpath = "//tr[@class='contactTableBodyRow']")
    public List<WebElement> contacts;
}
