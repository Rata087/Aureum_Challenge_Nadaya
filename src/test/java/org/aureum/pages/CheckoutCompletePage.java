package org.aureum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutCompletePage extends PageObject {

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;


    public boolean messageExist(String message) {
        try {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + message + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnBackHomeButton() {
        backHomeButton.click();
    }
}
