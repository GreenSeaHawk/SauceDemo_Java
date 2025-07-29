
Feature: Login

  Background:
    Given The user is on the login page

  Scenario: Login User with correct email and password
    When The user inputs valid username
    And The user inputs valid password
    And The user clicks login
    Then The user navigates to inventory page

  Scenario: Login fails with empty username and password
    When The user clicks login
    Then The user sees an x icon next to the username and password fields
    And The user sees an error message "Username is required"




