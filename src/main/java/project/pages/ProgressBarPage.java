package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class ProgressBarPage extends BasePage {
    public ProgressBarPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Progress Bar')]"), "Label of Progress Bar page"));
    }

    final static Logger log = Logger.getLogger(ProgressBarPage.class);

    private By progressBarLoc = By.xpath("//div[@role='progressbar']");
    private By startStopButtonLoc = By.id("startStopButton");


    private Label progressBar = new Label(progressBarLoc, "Progress Bar");
    private Button startStopButton = new Button(startStopButtonLoc, "Progress Bar");


    private NavigateBar navBar = new NavigateBar();

    public NavigateBar getNavBar() {
        return navBar;
    }

    public void setProgress(int age, int maxItaration) {
        int progress = Integer.parseInt(progressBar.findeElement().getAttribute("aria-valuenow"));
        startStopButton.click();
        long iteration = 0;
        while (age != progress) {
            progress = Integer.parseInt(progressBar.findeElement().getAttribute("aria-valuenow"));
            iteration++;
            if (iteration > maxItaration) {
                log.error("Too much iteration of loop");
                break;
            }
        }
        startStopButton.click();
    }

    public int getPropgress() {
        return Integer.parseInt(progressBar.findeElement().getAttribute("aria-valuenow"));
    }
}
