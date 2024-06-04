package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
        log.info("Starting selectingTwoCheckboxesTest");
        // Open Checkboxes page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        // Click on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
        // Select all checkboxes
        checkboxesPage.selectAllCheckboxes();
        // Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.arAllCheckboxesChecked(), "Not all checkboxes are checked");
    }
}
