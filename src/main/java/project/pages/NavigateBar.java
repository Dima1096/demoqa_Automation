package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.pages.BasePage;

public class NavigateBar extends BasePage {

    public NavigateBar() {
        super(new Button(By.xpath("//button[@class= 'navbar-toggler']"), "Toggle for navigate bar"));
    }

    private By alertsLoc = By.xpath("//span[contains(text(),'Alerts')]");
    private By nestedFramesLoc = By.xpath("//span[contains(text(),'Nested Frames')]");
    private By framesLoc = By.xpath("//span[text()='Frames']");
    private By webTablesLoc = By.xpath("//span[text()='Web Tables']");
    private By browserWindowsLoc = By.xpath("//span[text()='Browser Windows']");
    private By elementsLoc = By.xpath("//div[@class='header-text' and text()='Elements']");
    private By linksLoc = By.xpath("//span[text()='Links']");
    private By sliderLoc = By.xpath("//span[text()='Slider']");
    private By progressBarLoc = By.xpath("//span[text()='Progress Bar']");
    private By datePickerLoc = By.xpath("//span[text()='Date Picker']");
    private By uploadAndDownloadLoc = By.xpath("//span[text()='Upload and Download']");


    private Button alerts = new Button(alertsLoc, "Alerts button");
    private Button nestedFrames = new Button((nestedFramesLoc), "Nested Frames button");
    private Button frames = new Button((framesLoc), "Frames button");
    private Button webTables = new Button((webTablesLoc), "Web tables button");
    private Button browserWindows = new Button((browserWindowsLoc), "Browser windows button");
    private Button elements = new Button((elementsLoc), "Elements button");
    private Button links = new Button((linksLoc), "Links button");
    private Button slider = new Button((sliderLoc), "Slider button");
    private Button progressBar = new Button((progressBarLoc), "Progress Bar button");
    private Button datePicker = new Button((datePickerLoc), "Date Picker button");
    private Button uploadAndDownload = new Button((uploadAndDownloadLoc), "Upload And Download button");

    public void clickAlert() {
        alerts.click();
    }

    public void clickUploadAndDownload() {
        uploadAndDownload.clickJS();
    }

    public void clickNestedFrames() {
        nestedFrames.click();
    }

    public void clickFrames() {
        frames.click();
    }

    public void clickWebTables() {
        webTables.click();
    }

    public void clickBrowserWindows() {
        browserWindows.clickJS();
    }

    public void clickElements() {
        elements.clickJS();
    }

    public void clickLinks() {
        links.clickJS();
    }

    public void clickSlider() {
        slider.clickJS();
    }

    public void clickProgressBar() {
        progressBar.clickJS();
    }

    public void clickDatePicker() {
        datePicker.clickJS();
    }


}
