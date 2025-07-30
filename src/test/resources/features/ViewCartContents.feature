Feature: View Cart Contents

  Background: Logged in as standard user
    Given The user navigates to the login page
    And The user inputs valid username
    And The user inputs valid password
    And The user clicks login
    And The user is taken to the inventory page

  Scenario: Navigate to cart
    When The user clicks on the cart icon
    Then The user is taken to the cart page
    And The user sees an empty cart

  Scenario: Navigate back to products page
    When The user clicks on the cart icon
    And The user is taken to the cart page
    And The user clicks on Continue Shopping
    Then The user is taken to the inventory page

  Scenario: Add 1 product to cart and navigate to cart
    When The user adds 1 items to the cart
    And The user clicks on the cart icon
    And The user is taken to the cart page
    Then The user sees the same products in their cart

  Scenario: Add 6 products to cart and navigate to cart
    When The user adds 6 items to the cart
    And The user clicks on the cart icon
    And The user is taken to the cart page
    Then The user sees the same products in their cart