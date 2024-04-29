package org.aureum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends PageObject {

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement filterDropdown;

    private final String addAndRemoveButtonXpath = "//div[@class='inventory_item_description']//button";
    private final String productNameXpath = "//div[@class='inventory_item_description']//div/a/div";
    private final String productsPriceXpath = "//div[@class='inventory_item_description']//div[2]/div";


    public void clickOnAddToCartOnFirstProduct() {
        WebElement element = getDriver().findElements(By.xpath(addAndRemoveButtonXpath)).get(0);
        element.click();
    }

    public String getAddOrDeleteButtonTextOnFirstProduct() {
        WebElement element = getDriver().findElements(By.xpath(addAndRemoveButtonXpath)).get(0);
        return element.getText();
    }

    public String getFirstProductName() {
        WebElement element = getDriver().findElements(By.xpath(productNameXpath)).get(0);
        return element.getText();
    }

    public String getFirstProductPrice() {
        WebElement element = getDriver().findElements(By.xpath(productsPriceXpath)).get(0);
        return element.getText();
    }

    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    public void selectFilterOption(String filterValue) {
        selectFromDropdown(filterDropdown, filterValue);
    }

    public boolean validateSortByHighToLowPrice() {
        List<WebElement> elementList = getDriver().findElements(By.xpath(productsPriceXpath));

        for (int i = 1; i < elementList.size(); i++) {
            // Get price as String and remove currency sign
            String actualPriceStr = elementList.get(i).getText().replace("$", "").trim();
            String prevPriceStr = elementList.get(i - 1).getText().replace("$", "").trim();

            // Convert prices from String to Double for comparison
            double actualPrice = Double.parseDouble(actualPriceStr);
            double prevPrice = Double.parseDouble(prevPriceStr);

            // Check if current price is higher than previous price
            if (actualPrice > prevPrice) {
                return false;
            }
        }
        return true;
    }

    public boolean validateSortByNameZToA() {
        List<WebElement> elementList = getDriver().findElements(By.xpath(productNameXpath));

        for (int i = 1; i < elementList.size(); i++) {
            // Compares the current string with the specified string ignoring case differences.
            if (elementList.get(i).getText().compareToIgnoreCase(String.valueOf(elementList.get(i - 1).getText())) > 0) {
                return false;
            }
        }
        return true;
    }
}
