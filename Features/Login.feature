@Regression
Feature: Login Functionality

  Scenario: Verify the Login functinality with valid credentils
    Given User should be noOpecommerce HomePage
    When user clicks on login button from HomePage
    And user enters the valid credentials
    Then user should be successfully logged in

@Regression @Integration
  Scenario Outline: Verify the Login functionality with combinations
    Given User should be noOpecommerce HomePage
    When user clicks on login button from HomePage
    And user enters the "<email>" and "<password>" on login screen
    And User click on login button
    Then user should be successfully logged in

    Examples: 
      | email           | password  |
      | abc10@gmail.com | Iulc@8976 |
      | abc20@gmail.com | Iulc@8975 |
      | abc30@gmail.com | Iulc@8974 |
