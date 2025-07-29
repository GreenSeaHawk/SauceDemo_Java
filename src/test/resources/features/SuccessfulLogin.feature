
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

  Scenario: Login fails with username only
    When The user inputs valid username
    And The user clicks login
    Then The user sees an x icon next to the username and password fields
    And The user sees an error message "Password is required"

  Scenario: Login fails with password only
    When The user inputs valid password
    When The user clicks login
    Then The user sees an x icon next to the username and password fields
    And The user sees an error message "Username is required"

  Scenario: Session is maintained after login
    Given The user inputs valid username
    And The user inputs valid password
    And The user clicks login
    When The user refreshes the page
    Then The user navigates to inventory page

#  Might try and code at a later date:
#  Scenario: Session ends after browser is closed
#    Given I have entered the correct username and password.
#    And I click on Login
#    When I close the browser completely
#    And I reopen the browser
#    And I try to access the product listings page
#    Then I should be redirected to the login page


