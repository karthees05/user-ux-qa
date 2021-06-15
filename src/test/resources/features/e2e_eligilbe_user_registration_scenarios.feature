@e2e_tests
Feature: End to End Happy path flow for User Registration Web application

  @eligible_user_registration
  Scenario Outline: Test the user registration application with valid name, address, email
    Given user navigates to Home Page
    When user enters the registration details <name> , <email> , <address>
    And user submits the registration form
    Then user is able to see the following message
      | Thanks for submitting your application, you are eligible for this cards: |
    And user is able to see their eligible cards <eligibleCards>

    Examples:
      | name    | email                   | address        | email                   | eligibleCards |
      | Boris   | iamboris@testmail.com   | test address 1 | iamboris@testmail.com   | C1            |
      | Angela  | iamangela@testmail.com  | test address 2 | iamangela@testmail.com  | C1, C2        |
      | Theresa | iamtheresa@testmail.com | test address 3 | iamtheresa@testmail.com | C2            |
