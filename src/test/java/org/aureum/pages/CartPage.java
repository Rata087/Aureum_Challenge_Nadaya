package org.aureum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement inventoryItemName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement inventoryItemPrice;


    public boolean onlyOneItemValidation() {
        List<WebElement> elementList = getDriver().findElements(By.xpath("//div[@class='cart_item']"));
        return elementList.size() == 1;
    }

    public String getProductName() {
        return inventoryItemName.getText();
    }

    public String getProductPrice() {
        return inventoryItemPrice.getText();
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }
}
