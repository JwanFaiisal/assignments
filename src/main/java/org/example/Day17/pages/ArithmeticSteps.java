package org.example.Day17.pages;


import io.cucumber.java.en.*;
import org.junit.Assert;

public class ArithmeticSteps {
    int num1, num2, result;
    String message;

    @Given("the calculator is open")
    public void the_calculator_is_open() {
        System.out.println("Calculator is ready!");
    }

    @When("the user adds {int} and {int}")
    public void the_user_adds_and(Integer a, Integer b) {
        num1 = a;
        num2 = b;
        result = num1 + num2;
    }

    @When("the user subtracts {int} from {int}")
    public void the_user_subtracts_from(Integer a, Integer b) {
        num1 = a;
        num2 = b;
        result = num2 - num1;
    }

    @When("the user divides {int} by {int}")
    public void the_user_divides_by(Integer a, Integer b) {
        num1 = a;
        num2 = b;
        if (num2 == 0) {
            message = "Error: Cannot divide by zero!";
        } else {
            result = num1 / num2;
        }
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer expected) {
        Assert.assertEquals(expected.intValue(), result);
        System.out.println("Test Passed! Result = " + result);
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertEquals("Error: Cannot divide by zero!", message);
        System.out.println("Error message displayed: " + message);
    }

    @Then("the calculator should not crash")
    public void the_calculator_should_not_crash() {
        System.out.println("Calculator is still running fine!");
    }
}
