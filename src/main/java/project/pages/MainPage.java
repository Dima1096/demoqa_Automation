package project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import project.myFramework.elements.Button;
import project.myFramework.elements.Label;
import project.myFramework.pages.BasePage;

public class MainPage extends BasePage {
    final static Logger log = Logger.getLogger(MainPage.class);

    public MainPage() {
        super(new Label(By.xpath("//div[@class='home-banner']"),"Label of main page"));
    }

    private By alerts = By.xpath("//div//*[contains(text(),'Alerts, Frame & Windows')]");
    private By elementsloc = By.xpath("//div//*[contains(text(),'Elements')]");
    private By widgetsLoc = By.xpath("//div//*[contains(text(),'Widgets')]");

    private Button alertsButton = new Button(alerts,"Alerts, frame & windows Button" );
    private Button elementsButton = new Button(elementsloc, "Elements button");
    private Button widgetsButton = new Button(widgetsLoc, "Elements button");

    public void clickAlertsButton(){
        alertsButton.clickJS();
        log.info(alertsButton.getName()+" is clicked");
    }

    public void clickElementsButton(){
        elementsButton.clickJS();
        log.info(elementsButton.getName()+" is clicked");
    }

    public void clickWidgetsButton(){
        widgetsButton.clickJS();
    }

}
