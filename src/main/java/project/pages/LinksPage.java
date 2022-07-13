package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class LinksPage extends BasePage {
    public LinksPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Links')]"), "Label of Links page"));
    }


    private By homeloc = By.id("simpleLink");

    private Button home = new Button((homeloc), "Home button");

    public void clickHome() {
        home.findeElement().click();
    }
}
