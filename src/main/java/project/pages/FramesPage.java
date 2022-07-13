package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import project.myFramework.browserUtill.Frame;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class FramesPage extends BasePage {
    public FramesPage() {
        super(new Label(By.xpath("//div[@class='main-header' and text()='Frames']"), "Label of Alerts page"));
    }

    final static Logger log = Logger.getLogger(FramesPage.class);

    private By FrameOneLoc = By.id("frame1");
    private By FrameTwoLoc = By.id("frame2");
    private By bodyOfFrameOneLoc = By.id("sampleHeading");
    private By bodyOfFrameTwoLoc = By.id("sampleHeading");
    private Label bodyOfFrameone = new Label(bodyOfFrameOneLoc, "Body of frame one");
    private Label bodyOfFrameTwo = new Label(bodyOfFrameTwoLoc, "Body of frame two");

    private Frame FrameOne = new Frame(FrameOneLoc, "Frame One");
    private Frame FrameTwo = new Frame(FrameTwoLoc, "Frame Two");

    public String getTextFromFrameOne() {
        FrameOne.switchToFrame();
        String text = bodyOfFrameone.findeElement().getText();
        FrameOne.leaveFrame();
        log.info("got text from " + FrameOne.getName());
        return text;
    }

    public String getTextFromFrameTwo() {
        FrameOne.switchToFrame();
        String text = bodyOfFrameTwo.findeElement().getText();
        FrameOne.leaveFrame();
        log.info("got text from " + FrameTwo.getName());
        return text;
    }

}
