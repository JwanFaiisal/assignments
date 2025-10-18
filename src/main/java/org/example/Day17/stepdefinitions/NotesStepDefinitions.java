package org.example.Day17.stepdefinitions;


import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.example.Day17.utilities.Driver;

import java.util.List;
import java.util.Map;

public class NotesStepDefinitions {

    WebDriver driver = Driver.getDriver();

    @Given("the user is on the Notes Management page")
    public void the_user_is_on_the_notes_management_page() {
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
    }

    @When("the user adds the following notes")
    public void the_user_adds_the_following_notes(DataTable dataTable) {
        List<Map<String, String>> notes = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> noteData : notes) {
            String title = noteData.get("title");
            String note = noteData.get("note");

            driver.findElement(By.id("note-title-input")).sendKeys(title);
            driver.findElement(By.id("note-details-input")).sendKeys(note);
            driver.findElement(By.id("add-note")).click();
        }
    }

    @Then("all notes should be added successfully")
    public void all_notes_should_be_added_successfully() {
        List<WebElement> noteTitles = driver.findElements(By.cssSelector(".title-note-in-list"));
        Assert.assertEquals(10, noteTitles.size());
        System.out.println("✅ All 10 notes were added successfully!");
        Driver.closeDriver();
    }

}
