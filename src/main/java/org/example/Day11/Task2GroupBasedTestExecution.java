package org.example.Day11;


import org.testng.annotations.Test;

public class Task2GroupBasedTestExecution {

    @Test(groups = {"smoke"})
    public void testLogin() {
        System.out.println("Smoke Test: Login Test");
    }

    @Test(groups = {"regression"})
    public void testSearch() {
        System.out.println("Regression Test: Search Test");
    }

    @Test(groups = {"api"})
    public void testAPIResponse() {
        System.out.println("API Test: Verify API Response");
    }

    @Test(groups = {"smoke", "regression"})
    public void testAddToCart() {
        System.out.println("Smoke & Regression Test: Add to Cart");
    }
}
