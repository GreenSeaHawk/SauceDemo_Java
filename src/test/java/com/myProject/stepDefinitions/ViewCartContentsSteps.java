package com.myProject.stepDefinitions;


import com.myProject.pages.ViewCartContentsPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViewCartContentsSteps {

    ViewCartContentsPage vCCP = new ViewCartContentsPage();
    List<Map<String, String>> itemsAdded;

    @When("The user clicks on the cart icon")
    public void the_user_clicks_on_the_cart_icon() {
        vCCP.clickOn(vCCP.shoppingCartLink);
    }

    @Then("The user is taken to the cart page")
    public void the_user_is_taken_to_the_cart_page() {
        assertEquals("https://www.saucedemo.com/cart.html", Driver.get().getCurrentUrl());

    }

    @And("The user sees an empty cart")
    public void the_user_sees_an_empty_cart() {
        assertEquals(0, vCCP.cartItems.size());
    }

    @And("The user clicks on Continue Shopping")
    public void the_user_clicks_on_continue_shopping() {
        vCCP.clickOn(vCCP.continueShoppingButton);
    }

    @When("The user adds {int} items to the cart")
    public void the_user_adds_int_items_to_the_cart(int num) {
       itemsAdded = vCCP.addToCartAndStoreItemDetails(vCCP.inventoryItems, num);
    }

    @Then("The user sees the same products in their cart")
    public void the_user_sees_the_same_products_in_their_cart() {
        assertEquals(itemsAdded, vCCP.getAllCartItems(vCCP.cartItems));
//        System.out.println(itemsAdded);
    }
}
