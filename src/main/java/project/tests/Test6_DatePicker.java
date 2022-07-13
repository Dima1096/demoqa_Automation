package project.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.config.JsonParser;
import project.myFramework.browserUtill.BrowserUtill;
import project.myFramework.myUtills.Utills;
import project.pages.DatePickerPage;
import project.pages.MainPage;
import project.pages.WidgetsPage;

import java.util.Locale;

public class Test6_DatePicker extends BaseTest {
    final static Logger log = Logger.getLogger(Test6_DatePicker.class);
    @Test
    public void testDatePicker() {
        log.info("Step 1");
        BrowserUtill.get(JsonParser.parseURL());
        MainPage mainP = new MainPage();
        Assert.assertTrue(mainP.isOpen(), "Main page is not opened");
        log.info("Step 2");
        mainP.clickWidgetsButton();
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getNavBar().clickDatePicker();
        DatePickerPage datePickerPage = new DatePickerPage();
        Assert.assertTrue(datePickerPage.isOpen(), "Date Picker Page is not opened");
        String currentDate = Utills.getTimeFormat("MM/dd/yyyy");
        log.info("Current Date: " + currentDate);
        Assert.assertTrue(datePickerPage.getSelectData().equals(currentDate), "Select Date Input has incorrect value");
        String dateAndTime = Utills.getTimeFormat("LLLL d, yyyy h:mm a", Locale.US);
        log.info("Current Date and time: " + dateAndTime);
        Assert.assertTrue(datePickerPage.getDateAndTimeInput().equals(dateAndTime), "Date And Time Input has incorrect value");
        log.info("Step 3");
        datePickerPage.setNext29Febr(Utills.getNextLeapYear());
        Assert.assertTrue(datePickerPage.getSelectData().equals("02/29/"+Utills.getNextLeapYear()),"Date is incorrect");
    }
}
