package org.aureum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public void inputUser(String user) {
        waitFor(userNameInputField).sendKeys(user);
    }

    public void inputPassword(String psw) {
        waitFor(passwordInputField).sendKeys(psw);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }
}
