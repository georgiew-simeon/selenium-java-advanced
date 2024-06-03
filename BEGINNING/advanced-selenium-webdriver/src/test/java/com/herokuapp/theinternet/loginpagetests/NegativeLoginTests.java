package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");

        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();

        // enter negative username and password
        loginPage.negativeLogIn(username, password);
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageTest();

        // Verification
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(message.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: " + expectedErrorMessage);
    }
}
