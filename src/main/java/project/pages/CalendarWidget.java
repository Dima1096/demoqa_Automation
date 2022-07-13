package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.elements.Input;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class CalendarWidget extends BasePage {
    public CalendarWidget() {
        super(new Label(By.xpath("//div[@class='react-datepicker__month-container']"), "calendar"));
    }

    private By yearDropdownLoc = By.xpath("//select[@class='react-datepicker__year-select']");
    private By monthDropdownLoc = By.xpath("//select[@class='react-datepicker__month-select']");
    private String yearItemLoc = "//select[@class='react-datepicker__year-select']/option[text()=%d]";
    private String monthItemLoc = "//select[@class='react-datepicker__month-select']/option[%s]";
    private String dayLoc = "//div[contains(@aria-label,'%s') and text()=%s]";

    private Input year = new Input(yearDropdownLoc, "year dropdown");
    private Input month = new Input(monthDropdownLoc, "year dropdown");

    public void setMonth(String numberOfMonth) {
        month.click();
        Button moth = new Button(By.xpath(String.format(monthItemLoc, numberOfMonth)), "Month" + numberOfMonth);
        moth.click();
    }

    public void setYear(int yearNumber) {
        year.click();
        Button yearItem = new Button(By.xpath(String.format(yearItemLoc, yearNumber)), "year" + yearNumber);
        yearItem.click();
    }

    public void setDay(String month, String day) {
        Button dayButton = new Button(By.xpath(String.format(dayLoc, month, day)), day + " " + month);
        dayButton.click();

    }
}
