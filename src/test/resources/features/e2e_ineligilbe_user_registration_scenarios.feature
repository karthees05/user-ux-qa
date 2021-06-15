@e2e_tests
Feature: Validation for in-eligible user

  @ineligible_user_registration
  Scenario Outline: Test the user registration application with in-valid user data and validate the error messages
    Given user navigates to Home Page
    When user enters the registration details <name> , <email> , <address>
    And user submits the registration form
    Then user is able to see the following message
      | Unfortunately you're not eligible for any cards |

    Examples:
      | name          | email                      | address         |
      | invaliduser_1 | invaliduser_1@testmail.com | invalid address |
