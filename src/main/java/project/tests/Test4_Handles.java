package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.config.JsonParser;
import project.myFramework.browserUtill.BrowserUtill;
import project.myFramework.driver.Driver;
import project.pages.*;

public class Test4_Handles extends BaseTest {
    final static Logger log = Logger.getLogger(Test4_Handles.class);

    @Test
    public void testHandles(){
        log.info("Step 1");
        BrowserUtill.get(JsonParser.parseURL());
        MainPage mainP = new MainPage();
        Assert.assertTrue(mainP.isOpen(), "Main page is not opened");
        log.info("Step 2");
        mainP.clickAlertsButton();
        AlertsFrameWindowsPage alFrWinP = new AlertsFrameWindowsPage();
        alFrWinP.getNavBar().clickBrowserWindows();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        Assert.assertTrue(browserWindowsPage.isOpen(),"Browser windows page is not opened");
        log.info("Step 3");
        String originalWindow = BrowserUtill.getIdWindows();
        browserWindowsPage.clickNewTab();
        Assert.assertTrue(BrowserUtill.numberOfWindows()==2,"new tab is not opened");
        SimplePage simplePage = new SimplePage();
        BrowserUtill.switchToNewWindow(originalWindow);
        Assert.assertTrue(simplePage.isOpen(),"Simple page is not opened");
        log.info("Step 4");
        Driver.initi().close();
        Driver.initi().switchTo().window(originalWindow);
        Assert.assertTrue(browserWindowsPage.isOpen(),"Browser windows page is not opened");
        log.info("Step 5");
        browserWindowsPage.getNavBar().clickElements();
        browserWindowsPage.getNavBar().clickLinks();
        LinksPage linksPage =new LinksPage();
        Assert.assertTrue(linksPage.isOpen(),"Links page is not opened");
        log.info("Step 6");
        linksPage.clickHome();
        Assert.assertTrue(BrowserUtill.numberOfWindows()==2,"new tab is not opened");
        BrowserUtill.switchToNewWindow(originalWindow);
        MainPage mainP2 = new MainPage();
        Assert.assertTrue(mainP2.isOpen(), "Main page is not opened");
        log.info("Step 7");
        Driver.initi().switchTo().window(originalWindow);
        Assert.assertTrue(linksPage.isOpen(),"Links page is not opened");




    }
}
