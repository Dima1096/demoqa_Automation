package project.pages;

import org.openqa.selenium.By;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class SimplePage extends BasePage {
    public SimplePage() {
        super(new Label(By.id("sampleHeading"), "Simple page"));
    }
}
