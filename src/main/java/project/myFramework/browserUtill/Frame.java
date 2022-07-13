package project.myFramework.browserUtill;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.myFramework.driver.Driver;

public class Frame {
    private By locator;
    private String name;

    public Frame(By locator, String name) {
        this.locator=locator;
        this.name=name;
    }

    final static Logger log = Logger.getLogger(Frame.class);
    private WebElement frame;

    public void switchToFrame() {
        WebElement frame = Driver.initi().findElement(locator);
        this.frame = frame;
        Driver.initi().switchTo().frame(frame);
        log.info(name + " is opened");
    }

    public void leaveFrame() {
        Driver.initi().switchTo().defaultContent();
        log.info("Switched to default content");
    }

    public String getName() {
        return name;
    }

}
