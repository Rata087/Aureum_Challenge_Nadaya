package org.aureum.steps;

import io.cucumber.java.en.And;
import org.aureum.pages.CheckoutInformationPage;


public class CheckoutInformationStepDefinitions {
    CheckoutInformationPage checkoutInformationPage;

    @And("completes the First Name field with {string} on the Checkout: Your Information page")
    public void completesFirstNameField(String firstName) {
        checkoutInformationPage.inputFirstName(firstName);
    }

    @And("completes the Last Name field with {string} on the Checkout: Your Information page")
    public void completesLastNameField(String lastName) {
        checkoutInformationPage.inputLastName(lastName);
    }

    @And("completes the Postal Code field with {string} on the Checkout: Your Information page")
    public void completesPostalCodeField(String zipCode) {
        checkoutInformationPage.inputPostalCode(zipCode);
    }

    @And("clicks on Continue button on the Checkout: Your Information page")
    public void clicksOnContinueButton() {
        checkoutInformationPage.clickOnContinueButton();
    }
}
