package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {


    private final By usernameLocator = By.id("tomsmith");
    private final By passwordLocator = By.id("SuperSecretPassword!");
    private final By logInButtonLocator = By.tagName("button");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Execute Log in
     */
    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing logIn with username [" + username + "] and password [" + password + "]");
        type(username, this.usernameLocator);
        type(password, this.passwordLocator);
        click(this.logInButtonLocator);
        return new SecureAreaPage(driver, log);
    }

}
