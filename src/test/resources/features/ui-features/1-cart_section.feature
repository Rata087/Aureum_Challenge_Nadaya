@AureumChallenge @UiTests
Feature: Cart Section / Add to Cart Process

  Scenario: Verify that an item can be added to the cart and is visible on the cart page
    Given the user opens the Saucedemo page
    And logs in with valid credentials
    When clicks on the Add to cart button on the first product in the Inventory list
    Then validates that the Add to cart button changed to "Remove" on the first product in the Inventory list
    And gets the first Product Name in the Inventory list
    And gets the first Product Price in the inventory list
    And clicks on the Cart icon in the header menu
    And validates that only one item is visible on the Cart page
    And the Product Name and Price are correct on the Cart page
