@AureumChallenge @UiTests
Feature: Purchase/Checkout Process

  Scenario: Ensure the user can complete the purchase/checkout process
    Given the user opens the Saucedemo page
    And logs in with valid credentials
    And clicks on the Add to cart button on the first product in the Inventory list
    And gets the first Product Name in the Inventory list
    And gets the first Product Price in the inventory list
    And clicks on the Cart icon in the header menu
    And validates that only one item is visible on the Cart page
    And the Product Name and Price are correct on the Cart page
    When clicks on Checkout button on the Cart Page
    And completes the First Name field with "Test" on the Checkout: Your Information page
    And completes the Last Name field with "LastTest" on the Checkout: Your Information page
    And completes the Postal Code field with "9000" on the Checkout: Your Information page
    And clicks on Continue button on the Checkout: Your Information page
    And validates the Product Name and Price are correct on the Checkout: Overview page
    And clicks on Finish button
    Then verifies that the message "Thank you for your order!" is present on the Checkout: Complete page
    And verifies that the message "Your order has been dispatched, and will arrive just as fast as the pony can get there!" is present on the Checkout: Complete page
    And clicks on Back Home button on the Checkout: Complete page
