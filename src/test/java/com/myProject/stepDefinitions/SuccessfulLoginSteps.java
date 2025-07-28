package com.myProject.stepDefinitions;

import com.myProject.pages.SuccessfulLoginPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertTrue;

public class SuccessfulLoginSteps {

    SuccessfulLoginPage successfulLoginPage = new SuccessfulLoginPage();

    @Given("The user is on the saucedemo page")
    public void the_user_is_on_the_saucedemo_page() {
        Driver.get().get("https://www.saucedemo.com/");
    }

    @When("The user inputs valid username")
    public void the_user_inputs_valid_username() {
        successfulLoginPage.inputText(successfulLoginPage.usernameBox, "standard_user");
    }

    @And("The user inputs valid password")
    public void the_user_inputs_valid_password() {
        successfulLoginPage.inputText(successfulLoginPage.passwordBox, "secret_sauce");
    }

    @And("The user clicks login")
    public void the_user_clicks_login() {
        successfulLoginPage.login();
    }

    @Then("The user navigates to inventory page")
    public void the_user_navigates_to_inventory_page() {
        assertTrue(Driver.get().getCurrentUrl().contains("inventory.html"));

        Driver.closeDriver();
    }
}
