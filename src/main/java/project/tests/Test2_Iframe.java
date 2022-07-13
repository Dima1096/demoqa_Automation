package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.config.JsonParser;
import project.myFramework.browserUtill.BrowserUtill;
import project.myFramework.driver.Driver;
import project.pages.*;


public class Test2_Iframe extends BaseTest{
    final static Logger log = Logger.getLogger(Test2_Iframe.class);

    @Test
    public void testIframe(){
        log.info("Step 1");
        BrowserUtill.get(JsonParser.parseURL());
        MainPage mainP = new MainPage();
        Assert.assertTrue(mainP.isOpen(), "Main page is not opened");
        log.info("Step 2");
        mainP.clickAlertsButton();
        AlertsFrameWindowsPage alFrWinP = new AlertsFrameWindowsPage();
        alFrWinP.getNavBar().clickNestedFrames();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isOpen(), "Nested Frames page is not opened");
        nestedFramesPage.parentFrame.switchToFrame();
        Assert.assertTrue(nestedFramesPage.getTextFromParent().equals("Parent frame"), "text is not presented");
        nestedFramesPage.childFrame.switchToFrame();
        Assert.assertTrue(nestedFramesPage.getTextFromChild().equals("Child Iframe"),"text is not presented");
        nestedFramesPage.childFrame.leaveFrame();
        nestedFramesPage.parentFrame.leaveFrame();
        log.info("Step 3");
        nestedFramesPage.getNavBar().clickFrames();
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.getTextFromFrameOne().equals(framesPage.getTextFromFrameTwo()),"text is mot equal");


    }
}
