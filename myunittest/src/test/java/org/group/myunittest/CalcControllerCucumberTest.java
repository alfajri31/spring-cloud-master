package org.group.myunittest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class CalcControllerCucumberTest {

    private int num1;
    private int num2;
    private int result;

    @Given("the numbers {int} and {int}")
    public void givenTheNumbers(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @When("I add them together")
    public void whenIAddThemTogether() {
        result = num1 + num2;
    }

    @Then("the result should be {int}")
    public void thenTheResultShouldBe(int expectedResult) {
        if (result != expectedResult) {
            throw new AssertionError("Expected result: " + expectedResult + ", but got: " + result);
        }
    }
}
