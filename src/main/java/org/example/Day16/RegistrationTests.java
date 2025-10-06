package org.example.Day16;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test
    @Description("Validate correct SSN is accepted")
    public void testValidSSN() {
        enterSSN("123-45-6789");
        String value = driver.findElement(By.id("ssn")).getAttribute("value");
        Assert.assertEquals(value, "123-45-6789");
    }

    @Test
    @Description("Validate incorrect SSN is rejected")
    public void testInvalidSSN() {
        enterSSN("123456789");
        String pattern = driver.findElement(By.id("ssn")).getAttribute("pattern");
        Assert.assertEquals(pattern, "\\d{3}-\\d{2}-\\d{4}");
    }

    @Test
    @Description("Validate correct Email is accepted")
    public void testValidEmail() {
        enterEmail("test@example.com");
        String value = driver.findElement(By.id("email")).getAttribute("value");
        Assert.assertEquals(value, "test@example.com");
    }

    @Test
    @Description("Validate incorrect Email is rejected")
    public void testInvalidEmail() {
        enterEmail("test@com");
        String type = driver.findElement(By.id("email")).getAttribute("type");
        Assert.assertEquals(type, "email");
    }

    @Step("Enter SSN: {ssn}")
    private void enterSSN(String ssn) {
        WebElement ssnField = driver.findElement(By.id("ssn"));
        ssnField.clear();
        ssnField.sendKeys(ssn);
    }

    @Step("Enter Email: {email}")
    private void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(email);
    }
}
