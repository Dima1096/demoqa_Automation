package project.myFramework.elements;

import org.openqa.selenium.By;

public class Input extends BaseElement {
    public Input(By locator, String name) {
        super(locator, name);
    }

    public void sendKeys(String key) {
        findeElement().sendKeys(key);
    }
}
