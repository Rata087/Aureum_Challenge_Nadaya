package org.aureum.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.ConfiguredEnvironment;
import org.junit.Assert;
import org.aureum.pages.LoginPage;


public class LoginStepDefinitions {
    LoginPage loginPage;

    @After
    public void tearDown() {
        Serenity.getWebdriverManager().closeDriver();
    }

    @And("the user opens the Saucedemo page")
    public void OpensTheServiceNowPage() {
        loginPage.open();
        Assert.assertEquals("Swag Labs", loginPage.getTitle());
    }

    @And("logs in with valid credentials")
    public void logsInWithValidCredentials() {
        String user = ConfiguredEnvironment.getConfiguration().getEnvironmentVariables().getProperty("valid.user");
        String password = ConfiguredEnvironment.getConfiguration().getEnvironmentVariables().getProperty("valid.password");
        loginPage.inputUser(user);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals("Swag Labs", loginPage.getTitle());
    }
}
