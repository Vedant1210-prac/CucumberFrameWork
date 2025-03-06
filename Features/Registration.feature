@Functionality
Feature: Registration Fearure


  Scenario: Verify the registration functionality
    Given user should be nopcommerce home page
    When user should click on registration button
    And user should fill all the details on registration page
    Then user should display the registration successful message
