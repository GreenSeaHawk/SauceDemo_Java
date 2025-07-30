package com.myProject.stepDefinitions;

import com.myProject.pages.SuccessfulLoginPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnsuccessfulLoginSteps {

    SuccessfulLoginPage sLP = new SuccessfulLoginPage();

    @Then("The user sees correct error message")
    public void the_user_sees_correct_error_message() {
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = sLP.errorMessageContainer.getText();
        assertEquals(errorMessage, actualMessage);
    }

    @And("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        assertEquals("https://www.saucedemo.com/", Driver.get().getCurrentUrl());
    }

    @When("The user inputs invalid {string}")
    public void the_user_inputs_valid_username(String invalidUsername) {
        sLP.inputText(sLP.usernameBox, invalidUsername);
    }

}
