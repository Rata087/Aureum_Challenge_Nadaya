package org.aureum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutOverviewPage extends PageObject {

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement inventoryItemName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement inventoryItemPrice;


    public String getProductName() {
        return inventoryItemName.getText();
    }

    public String getProductPrice() {
        return inventoryItemPrice.getText();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }
}
