package org.example.Day15.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
    WebDriver driver;

    By nameInput = By.id("name");
    By phoneInput = By.id("phone");
    By emailInput = By.id("email");
    By saveBtn = By.xpath("//button[text()='Save']");

    public AddContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void addContact(String name, String phone, String email){
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(saveBtn).click();
    }
}