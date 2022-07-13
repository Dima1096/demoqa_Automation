package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class ElementsPage extends BasePage {
    public ElementsPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Elements)]"), "Label of Elements page"));
    }

    private NavigateBar navBar = new NavigateBar();

    public NavigateBar getNavBar() {
        return navBar;
    }

}
