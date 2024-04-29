package org.aureum.steps;

import io.cucumber.java.en.And;
import org.aureum.pages.InventoryPage;
import org.junit.Assert;


public class InventoryStepDefinitions {
    InventoryPage inventoryPage;
    public static String productName;
    public static String productPrice;


    @And("clicks on the Add to cart button on the first product in the Inventory list")
    public void clicksOnTheAddToCartButtonOnTheFirstProduct() {
        inventoryPage.clickOnAddToCartOnFirstProduct();
    }

    @And("validates that the Add to cart button changed to {string} on the first product in the Inventory list")
    public void validatesTheDeleteButtonOnTheFirstProduct(String btnName) {
        Assert.assertEquals(btnName, inventoryPage.getAddOrDeleteButtonTextOnFirstProduct());
    }

    @And("gets the first Product Name in the Inventory list")
    public void getsTheFirstProductName() {
        productName = inventoryPage.getFirstProductName();
    }

    @And("gets the first Product Price in the inventory list")
    public void getsTheFirstProductPrice() {
        productPrice = inventoryPage.getFirstProductPrice();
    }

    @And("clicks on the Cart icon in the header menu")
    public void clicksOnTheShoppingCartIcon() {
        inventoryPage.clickOnShoppingCartIcon();
    }

    @And("selects {string} in the filter dropdown on the Inventory list")
    public void selectsInTheFilterDropdown(String filterValue) {
        inventoryPage.selectFilterOption(filterValue);
    }

    @And("validates the items are sorted correctly by price high-to-low")
    public void validatesTheItemsAreSortedCorrectlyByPriceHighToLow() {
        Assert.assertTrue("Inventory is NOT being sorted correctly by price high-to-low", inventoryPage.validateSortByHighToLowPrice());
    }

    @And("validates the items are sorted correctly by name Z-to-A")
    public void validatesTheItemsAreSortedCorrectlyByNameZToA() {
        Assert.assertTrue("Inventory is NOT being sorted correctly by name Z-to-A", inventoryPage.validateSortByNameZToA());
    }
}
