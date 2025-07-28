
Feature: Login

  @smoke @login1
  Scenario: Login User with correct email and password
    Given The user is on the saucedemo page
    When The user inputs valid username
    And The user inputs valid password
    And The user clicks login
    Then The user navigates to inventory page




