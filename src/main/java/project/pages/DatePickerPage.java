package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import project.myFramework.elements.Input;
import project.myFramework.elements.Label;
import project.myFramework.myUtills.Utills;
import project.myFramework.pages.BasePage;

import java.util.Locale;

public class DatePickerPage extends BasePage {
    public DatePickerPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Date Picker')]"), "Label of Date Picker"));
    }

    final static Logger log = Logger.getLogger(DatePickerPage.class);
    private NavigateBar navBar = new NavigateBar();
    public NavigateBar getNavBar() {
        return navBar;
    };
    public CalendarWidget calendrWidget = new CalendarWidget();

    private By selectDateInputLoc = By.id("datePickerMonthYearInput");
    private By DateAndTimeInputLoc = By.id("dateAndTimePickerInput");

    private Input selectDateInput = new Input(selectDateInputLoc, "select Date Input");
    private Input dateAndTimeInput = new Input(DateAndTimeInputLoc, "Date And Time Input");

    public String getDateAndTimeInput() {
        String inpuValue = dateAndTimeInput.findeElement().getAttribute("value").trim();
        log.info("Date and time value: " + inpuValue);
        return inpuValue;
    }

    public void setNext29Febr(int year) {
        selectDateInput.click();
        calendrWidget.setMonth("2");
        calendrWidget.setYear(year);
        calendrWidget.setDay("February", "29");
    }

    public String getSelectData() {
        return selectDateInput.findeElement().getAttribute("value").trim();
    }
}
