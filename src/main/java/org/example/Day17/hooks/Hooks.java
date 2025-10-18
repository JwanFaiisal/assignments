package org.example.Day17.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.Day17.utilities.Driver;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("===== Test Started =====");
        System.out.println("Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("===== Test Finished =====");
        System.out.println("Status: " + scenario.getStatus());
        Driver.closeDriver();
    }
}
