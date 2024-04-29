@AureumChallenge @UiTests
Feature: Inventory Section

  Scenario: Verify that inventory items can be sorted by price, high-to-low, and the sorting is correct
    Given the user opens the Saucedemo page
    And logs in with valid credentials
    When selects "Price (high to low)" in the filter dropdown on the Inventory list
    Then validates the items are sorted correctly by price high-to-low


  Scenario: Ensure that inventory can be sorted by name, Z-to-A, and the sorting is correct
    Given the user opens the Saucedemo page
    And logs in with valid credentials
    When selects "Name (Z to A)" in the filter dropdown on the Inventory list
    Then validates the items are sorted correctly by name Z-to-A
