package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class AlertsFrameWindowsPage extends BasePage {
    public AlertsFrameWindowsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Alerts, Frame & Windows')]"), "Label of Alerts page"));
    }

    private NavigateBar navBar = new NavigateBar();

    public NavigateBar getNavBar() {
        return navBar;
    }
}
