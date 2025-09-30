package org.example.Day14.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class FluentWebTablePage {
    WebDriver driver;

    private By nameInput = By.id("nameInput");
    private By ageInput = By.id("ageInput");
    private By countrySelect = By.id("countrySelect");
    private By addRecordBtn = By.xpath("//button[text()='Add Record']");
    private By tableRows = By.xpath("//table//tr");

    public FluentWebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWebTablePage openPage() {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        return this;
    }

    public FluentWebTablePage enterName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public FluentWebTablePage enterAge(String age) {
        driver.findElement(ageInput).clear();
        driver.findElement(ageInput).sendKeys(age);
        return this;
    }

    public FluentWebTablePage selectCountry(String country) {
        Select select = new Select(driver.findElement(countrySelect));
        select.selectByVisibleText(country);
        return this;
    }

    public FluentWebTablePage clickAddRecord() {
        driver.findElement(addRecordBtn).click();
        return this;
    }

    // ميثود لإضافة سجل كامل
    public FluentWebTablePage addRecord(String name, String age, String country) {
        return this.enterName(name)
                .enterAge(age)
                .selectCountry(country)
                .clickAddRecord();
    }

    // تحقق من وجود سجل في الجدول
    public FluentWebTablePage verifyRecordExists(String name, String age, String country) {
        String xpath = String.format("//table//tr[td[text()='%s'] and td[text()='%s'] and td[text()='%s']]", name, age, country);
        WebElement row = driver.findElement(By.xpath(xpath));
        if (!row.isDisplayed()) {
            throw new AssertionError("Record not found: " + name + ", " + age + ", " + country);
        }
        return this;
    }

    // حذف سجل بناءً على الاسم (أو أي خلية فريدة)
    public FluentWebTablePage deleteRecordByName(String name) {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(name)) {
                WebElement deleteBtn = row.findElement(By.xpath(".//button[text()='Delete']"));
                deleteBtn.click();
                break;
            }
        }
        return this;
    }
}
