@e2e_tests
Feature: Mandatory fields validation

  @mandatory_field_missing_scenarios
  Scenario Outline: Validate the error messages for missing mandatory fields
    Given user navigates to Home Page
    When user enters the registration details <name> , <email> , <address>
    And user submits the registration form
    Then user is able to see the error message <errorMessage>

    Examples:
      | name  | email                 | address        | errorMessage                                              |
      |       | iamboris@testmail.com | address line 1 | Name is required.                                         |
      | Boris |                       | address line 1 | Email is required.                                        |
      | Boris | iamboris@testmail.com |                | Address is required.                                      |
      |       |                       |                | Name is required. Email is required. Address is required. |
      | Boris |                       |                | Email is required. Address is required.                   |
      |       |                       | address line 1 | Name is required. Email is required.                      |
      |       | iamboris@testmail.com |                | Name is required. Address is required.                    |
