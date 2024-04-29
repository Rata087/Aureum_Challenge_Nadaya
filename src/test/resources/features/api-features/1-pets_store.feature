@AureumChallenge @ApiTests
Feature: Pets Store API Tests

  Scenario Outline: Get all pets by status
    Given the user accesses the Petstore API
    When makes a GET request to get all <Pet Status> pets
    Then the response status code is 200
    And the response returns the list of pets with the <Pet Status> status
    And validates that the amount of pets is greater than 0
    And print the amount of <Pet Status> pets in the console

    Examples:
      | Pet Status |
      | available  |
      | pending    |
      | sold       |


  Scenario Outline: Add a new pet with Name and Status
    Given the user accesses the Petstore API
    When adds a new pet called <Name> in <Status> status
    Then the response status code is 200

    Examples:
      | Name     | Status    |
      | Snowball | available |
      | Michi    | pending   |
      | Dogui    | sold      |


  Scenario Outline: Update an existing pet
    Given the user accesses the Petstore API
    When updates the <Name> and <Status> of a pet by <ID>
    Then the response status code is 200
    And validates <Name> and <Status> are valid for the pet <ID>

    Examples:
      | ID                | Name  | Status |
      | 20240429135933087 | Dogsi | sold   |

  @api
  Scenario Outline: Create and Delete the newly created pet
    Given the user accesses the Petstore API
    And adds a new pet called <Name> in <Status> status
    And the response status code is 200
    When deletes the newly created pet
    Then the response status code is 200
    And verifies that the newly created pet is no longer present in the list of pets

    Examples:
      | Name  | Status |
      | Dogsi | sold   |


  @NoRun
  Scenario Outline: Delete pet by ID
    Given the user accesses the Petstore API
    When deletes a pet by <ID>
    Then the response status code is 200
    And validates that the <ID> no longer exists in the pet list

    Examples:
      | ID                |
      | 20240429135934856 |
