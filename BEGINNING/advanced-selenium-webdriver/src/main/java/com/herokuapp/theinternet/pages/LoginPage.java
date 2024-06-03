package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage extends BasePageObject {


    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By logInButtonLocator = By.tagName("button");
    private final By errorMessageLocator = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing logIn with username [" + username + "] and password [" + password + "]");
        type(username, this.usernameLocator);
        type(password, this.passwordLocator);
        click(this.logInButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public void negativeLogIn(String username, String password) {
        log.info("Executing negativeLogIn with username [" + username + "] and password [" + password + "]");
        type(username, this.usernameLocator);
        type(password, this.passwordLocator);
        click(this.logInButtonLocator);
    }

    public void waitForErrorMessage() {
        waitForVisibilityOf(this.errorMessageLocator, Duration.ofSeconds(5));
    }

    public String getErrorMessageTest() {
        return find(errorMessageLocator).getText();
    }
}
