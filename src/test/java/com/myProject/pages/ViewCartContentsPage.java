package com.myProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCartContentsPage extends BasePage {

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCartLink;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(className = "inventory_item_description")
    public List<WebElement> inventoryItems;

    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;


    public List<Map<String, String>> addToCartAndStoreItemDetails(List<WebElement> items, int count) {
        List<Map<String, String>> itemDetailsList = new ArrayList<>();

        // Limit to specified count
        for (int i = 0; i < Math.min(count, items.size()); i++) {
            WebElement item = items.get(i);

            String name = item.findElement(By.className("inventory_item_name")).getText();
            String price = item.findElement(By.className("inventory_item_price")).getText();
            String desc = item.findElement(By.className("inventory_item_desc")).getText();

            // Click the add to cart button
            item.findElement(By.tagName("button")).click();

            // Store details in a map
            Map<String, String> itemDetails = new HashMap<>();
            itemDetails.put("Name", name);
            itemDetails.put("Description", desc);
            itemDetails.put("Price", price);

            itemDetailsList.add(itemDetails);
        }

        return itemDetailsList;
    }

    public List<Map<String, String>> getAllCartItems(List<WebElement> items) {
        List<Map<String, String>> itemDetailsList = new ArrayList<>();

        // Limit to specified count
        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);

            String name = item.findElement(By.className("inventory_item_name")).getText();
            String price = item.findElement(By.className("inventory_item_price")).getText();
            String desc = item.findElement(By.className("inventory_item_desc")).getText();

            // Store details in a map
            Map<String, String> itemDetails = new HashMap<>();
            itemDetails.put("Name", name);
            itemDetails.put("Description", desc);
            itemDetails.put("Price", price);

            itemDetailsList.add(itemDetails);
        }

        return itemDetailsList;
    }



}
