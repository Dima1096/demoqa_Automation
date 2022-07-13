package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.config.JsonParser;
import project.myFramework.browserUtill.BrowserUtill;
import project.myFramework.driver.Driver;
import project.myFramework.myUtills.Asserts;
import project.myFramework.myUtills.Utills;
import project.pages.MainPage;
import project.pages.ProgressBarPage;
import project.pages.SliderPage;
import project.pages.WidgetsPage;

public class Test5_Slider_ProgressBar extends BaseTest {
    final static Logger log = Logger.getLogger(Test5_Slider_ProgressBar.class);
    final static int iterations = 1000;
    final static int variance = 2;

    @Test
    public void TestSliderProgressBar() {
        log.info("Step 1");
        BrowserUtill.get(JsonParser.parseURL());
        MainPage mainP = new MainPage();
        Assert.assertTrue(mainP.isOpen(), "Main page is not opened");
        log.info("Step 2");
        mainP.clickWidgetsButton();
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getNavBar().clickSlider();
        SliderPage sliderPage = new SliderPage();
        Assert.assertTrue(sliderPage.isOpen(), "Slider page is not opened");
        log.info("Step 3");
        int random = Utills.getRanomInt();
        log.info("random value:" + random);
        sliderPage.setSlider(random);
        Assert.assertTrue(sliderPage.getInputValue() == random, "values are not equal");
        log.info("Step 4");
        sliderPage.getNavBar().clickProgressBar();
        ProgressBarPage progressBarPage = new ProgressBarPage();
        Assert.assertTrue(progressBarPage.isOpen(), "Progress Bar page is not opened");
        log.info("Steps 5 and 6");
        int age = JsonParser.age();
        progressBarPage.setProgress(age, iterations);
        Assert.assertTrue(Asserts.compareWithVariance(progressBarPage.getPropgress(), age, variance), "values are not equal");

    }
}