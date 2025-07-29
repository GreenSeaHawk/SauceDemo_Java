package com.myProject.stepDefinitions;

import com.myProject.pages.SuccessfulLoginPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SuccessfulLoginSteps {

    SuccessfulLoginPage sLP = new SuccessfulLoginPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get("https://www.saucedemo.com/");
    }

    @When("The user inputs valid username")
    public void the_user_inputs_valid_username() {
        sLP.inputText(sLP.usernameBox, "standard_user");
    }

    @And("The user inputs valid password")
    public void the_user_inputs_valid_password() {
        sLP.inputText(sLP.passwordBox, "secret_sauce");
    }

    @And("The user clicks login")
    public void the_user_clicks_login() {
        sLP.login();
    }

    @Then("The user navigates to inventory page")
    public void the_user_navigates_to_inventory_page() {
        assertTrue(Driver.get().getCurrentUrl().contains("inventory.html"));
    }

    @Then("The user sees an x icon next to the username and password fields")
    public void the_user_sees_an_x_icon() {
        assertTrue(sLP.elementPresent(sLP.usernameErrorIcon));
        assertTrue(sLP.elementPresent(sLP.passwordErrorIcon));
    }

    @And("The user sees an error message {string}")
    public void the_user_sees_an_error_message(String expectedMessage) {
        String actualMessage = sLP.errorMessageContainer.getText();
        String errorMessage = "Epic sadface: " + expectedMessage;
        assertEquals(actualMessage, errorMessage);
    }

    @When("The user refreshes the page")
    public void the_user_refreshes_the_page() {
//        try {
//            Thread.sleep(2000);  // wait before refresh
//            sLP.refreshPage();
//            Thread.sleep(2000);  // wait after refresh
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        sLP.refreshPage();
    }
}
