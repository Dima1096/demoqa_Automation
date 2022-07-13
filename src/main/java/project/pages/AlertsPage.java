package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class AlertsPage extends BasePage {
    public AlertsPage() {
        super(new Label(By.id("javascriptAlertsWrapper"), "Label of Alerts page"));
    }

    final static Logger log = Logger.getLogger(AlertsPage.class);


    private By alertbuttonLoc = By.id("alertButton");
    private By cnfirmButtonLoc = By.id("confirmButton");
    private By confirmResultLoc = By.id("confirmResult");
    private By promptButtonLoc = By.id("promtButton");
    private By promptResultLoc = By.id("promptResult");
    private Button alertButton = new Button(alertbuttonLoc, "Alert button");
    private Button confirmButton = new Button(cnfirmButtonLoc, "Confirm button");
    private Button promtButton = new Button(promptButtonLoc, "Prompt button");
    private Label confirmResult = new Label(confirmResultLoc, "Confirm result");
    private Label promptResult = new Label(promptResultLoc, "Prompt result");


    private NavigateBar navBar = new NavigateBar();

    public NavigateBar getNavBar() {
        return navBar;
    }

    public void clickPromtButton() {
        promtButton.findeElement().click();
        log.info("click prom button");
    }

    public void clickConfirmButton() {
        confirmButton.findeElement().click();
        log.info("click Confirm button");
    }

    public void clickAlertButton() {
        alertButton.findeElement().click();
        log.info("click Alert button");
    }

    public String getConfirmResult() {
        return confirmResult.findeElement().getText();
    }

    public String getPromptResult() {
        return promptResult.findeElement().getText();
    }

}
