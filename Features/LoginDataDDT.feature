@LoginDDT
Feature: Login functionality with DDT

  Scenario Outline: Verify the Login functionality using DDT
    Given user should navigate to Login page
    When user should enter email and password provided in excel "<row_index>"
    

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
