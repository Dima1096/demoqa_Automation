package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class WidgetsPage extends BasePage {
    public WidgetsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Widgets')]"), "Label of Web Tables page"));
    }

    private NavigateBar navBar = new NavigateBar();
    public NavigateBar getNavBar() {
        return navBar;
    }
}
