package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import project.myFramework.elements.Input;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class SliderPage extends BasePage {
    public SliderPage() {
        super(new Label(By.xpath("//div[@class='main-header' and contains(text(),'Slider')]"), "Label of Web Tables page"));
    }

    private By sliderLoc = By.xpath("//input[@type='range']");
    private By inputLoc = By.id("sliderValue");

    private Input slider = new Input(sliderLoc, "Slider");
    private Input input = new Input(inputLoc, "Slider");

    private NavigateBar navBar = new NavigateBar();
    public NavigateBar getNavBar() {
        return navBar;
    }

    public void setSlider(int num) {
        slider.findeElement().click();
        int value = Integer.parseInt(slider.findeElement().getAttribute("value"));
        while (num != value) {
            if (num < value) {
                slider.findeElement().sendKeys(Keys.ARROW_DOWN);
            } else {
                slider.findeElement().sendKeys(Keys.ARROW_UP);
            }
            value = Integer.parseInt(slider.findeElement().getAttribute("value"));
        }
    }

    public int getInputValue() {
        return Integer.parseInt(input.findeElement().getAttribute("value"));
    }

}

