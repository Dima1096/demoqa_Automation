package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Browser Windows')]"), "Label of Browser windows"));
    }

    private NavigateBar navBar = new NavigateBar();

    public NavigateBar getNavBar() {
        return navBar;
    }

    private By newTabLoc = By.id("tabButton");

    private Button newTab = new Button((newTabLoc), "New tab button");

    public void clickNewTab() {
        newTab.findeElement().click();
    }

}
