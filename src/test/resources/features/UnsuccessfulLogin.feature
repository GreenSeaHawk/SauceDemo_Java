@known_defect
Feature: Unsuccessful Swag Login

  Background:
    Given The user is on the login page

  Scenario Outline: Unsuccessful Login
    When The user inputs invalid "<username>"
    And The user inputs valid password
    And The user clicks login
    Then The user sees correct error message
    And The user remains on the login page
    Examples:
      | username                |
      | problem_user            |
      | performance_glitch_user |
      | error_user|