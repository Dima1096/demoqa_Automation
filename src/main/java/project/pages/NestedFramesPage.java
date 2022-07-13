package project.pages;

import org.openqa.selenium.By;
import project.myFramework.browserUtill.Frame;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage() {
        super(new Label(By.xpath("//div[@class='main-header' and text() ='Nested Frames']"), "Nested Frames Page"));
    }

    private By parenFrameloc = By.id("frame1");
    private By bodyOfParentFrameLoc = By.xpath("/html/body");
    private By bodyOfChildFrameLoc = By.xpath("/html/body");
    private By childFrameloc = By.cssSelector("body > iframe");
    private Label bodyOfChildFrame = new Label(bodyOfChildFrameLoc, "Body of child frame");
    private Label bodyOfParentFrame = new Label(bodyOfParentFrameLoc, "Body of parent frame");
    public Frame parentFrame = new Frame(parenFrameloc, "parent Frame");
    public Frame childFrame = new Frame(childFrameloc, " child Frame");

    private NavigateBar navBar = new NavigateBar();

    public NavigateBar getNavBar() {
        return navBar;
    }

    public String getTextFromParent(){
       return bodyOfParentFrame.findeElement().getText();
    }

    public String getTextFromChild(){
        return bodyOfChildFrame.findeElement().getText();
    }


}
