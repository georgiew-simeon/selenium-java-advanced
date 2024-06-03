package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private final String expectedUrl = "https://the-internet.herokuapp.com/secure";
    private final By logOutButton = By.xpath("//a[@href='/logout']");
    private final By successMessage = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getExpectedUrl() {
        return expectedUrl;
    }

    public String getSuccessMessageText(){
        return find(successMessage).getText();
    }

    public boolean isLogOutButtonVisible(){
        return find(logOutButton).isDisplayed();
    }
}
