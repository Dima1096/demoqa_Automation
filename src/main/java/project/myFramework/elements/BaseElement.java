package project.myFramework.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.config.JsonParser;
import project.myFramework.driver.Driver;

import java.time.Duration;

public abstract class BaseElement {
    protected By locator;
    protected String name;

    BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }


    final static Logger log = Logger.getLogger(BaseElement.class);

    public WebElement findeElement() {
        new WebDriverWait(Driver.initi(), Duration.ofMillis(JsonParser.parstimeOut()))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = Driver.initi().findElement(locator);
        return element;
    }

    public String getName() {
        return this.name;
    }

    public void click() {
        new WebDriverWait(Driver.initi(), Duration.ofMillis(JsonParser.parstimeOut()))
                .until(ExpectedConditions.elementToBeClickable(locator));
        findeElement().click();
        log.info(name + "is clicked");
    }

    public void clickWithMove() {
        new WebDriverWait(Driver.initi(), Duration.ofMillis(JsonParser.parstimeOut()))
                .until(ExpectedConditions.elementToBeClickable(locator));
        Actions actions = new Actions(Driver.initi());
        actions.moveToElement(findeElement()).build().perform();
        findeElement().click();
        log.info(name + "is clicked");
    }

    public void clickJS() {
        JavascriptExecutor ex = (JavascriptExecutor) Driver.initi();
        ex.executeScript("arguments[0].click()", findeElement());
        log.info(name + "is clicked");
    }
    public String getText() {
        return findeElement().getText();
    }

    public boolean isDisplayed(){
        return findeElement().isDisplayed();
    }
}
