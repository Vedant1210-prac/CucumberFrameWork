Feature: Registration Fearure

  @Registration @Sanity
  Scenario: Verify the registration functionality
    Given User Navigates to Registration Page
    When User enters the data below formate
      | firstname   | John             |
      | lastname    | kennedy          |
      | email       | test10@gmail.com |
      | companyname | CAP              |
      | password    | test@123         |
    And user clicks on registration button
    Then user should be able to register successfully
