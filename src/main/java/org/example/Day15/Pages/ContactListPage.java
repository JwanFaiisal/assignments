package org.example.Day15.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ContactListPage {
    WebDriver driver;

    By addContactBtn = By.xpath("//button[text()='Add Contact']");
    By contactsRows = By.cssSelector(".contact-row");

    public ContactListPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToAddContact(){
        driver.findElement(addContactBtn).click();
    }

    public int getTotalContacts(){
        List<WebElement> contacts = driver.findElements(contactsRows);
        return contacts.size();
    }

    public boolean isContactDisplayed(String contactName){
        List<WebElement> contacts = driver.findElements(contactsRows);
        for(WebElement c : contacts){
            if(c.getText().contains(contactName)){
                return true;
            }
        }
        return false;
    }
}
