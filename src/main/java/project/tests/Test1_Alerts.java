package project.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.config.JsonParser;
import project.myFramework.browserUtill.AlertManager;
import project.myFramework.browserUtill.BrowserUtill;
import project.pages.AlertsFrameWindowsPage;
import project.pages.AlertsPage;
import project.pages.MainPage;

public class Test1_Alerts extends BaseTest {
    final static Logger log = Logger.getLogger(Test1_Alerts.class);


    @Parameters({"length"})
    @Test
    public void testAlerts(int length) {
        log.info("Step 1");
        BrowserUtill.get(JsonParser.parseURL());
        MainPage mainP = new MainPage();
        Assert.assertTrue(mainP.isOpen(), "Main page is not opened");
        log.info("Step 2");
        mainP.clickAlertsButton();
        AlertsFrameWindowsPage alFrWinP = new AlertsFrameWindowsPage();
        alFrWinP.getNavBar().clickAlert();
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.isOpen(), "Alerts page is not opened");
        log.info("Step 3");
        alertsPage.clickAlertButton();
        AlertManager alertManager = new AlertManager();
        alertManager.switchToAlert();
        Assert.assertTrue(alertManager.getText().equals("You clicked a button"), "text is different");
        log.info("Step 4");
        alertManager.dismiss();
        Assert.assertTrue(!alertManager.isAletrOpen(), "the alert is still open");
        log.info("Step 5");
        alertsPage.clickConfirmButton();
        alertManager.switchToAlert();
        Assert.assertTrue(alertManager.getText().equals("Do you confirm action?"), "text is different");
        log.info("Step 6");
        alertManager.accept();
        Assert.assertTrue(!alertManager.isAletrOpen(), "the alert is still open");
        Assert.assertTrue(alertsPage.getConfirmResult().equals("You selected Ok"), "text is different");
        log.info("Step 7");
        alertsPage.clickPromtButton();
        Assert.assertTrue(alertManager.getText().equals("Please enter your name"), "text is different");
        log.info("Step 8");
        String randomName = RandomStringUtils.randomAlphabetic(length);
        alertManager.sendKeys(randomName);
        alertManager.accept();
        Assert.assertTrue(!alertManager.isAletrOpen(), "the alert is still open");
        Assert.assertTrue(alertsPage.getPromptResult().equals("You entered " + randomName), "Name is different");


    }
}
