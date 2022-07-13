package project.myFramework.browserUtill;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.config.JsonParser;
import project.myFramework.driver.*;

import java.time.Duration;

public class AlertManager {
    final static Logger log = Logger.getLogger(AlertManager.class);

    private Alert alert;

    private WebDriverWait setWait() {
        return new WebDriverWait(Driver.initi(), Duration.ofSeconds(JsonParser.parstimeOut()));
    }

    public void switchToAlert() {

        setWait().until(ExpectedConditions.alertIsPresent());
        this.alert = Driver.initi().switchTo().alert();

    }

    public void dismiss() {
        log.info("click dismiss alert");
        alert.dismiss();
    }

    public void accept() {
        log.info("click accept alert");
        alert.accept();
    }

    public String getText() {
        return alert.getText();
    }

    public boolean isAletrOpen() {
        boolean res = false;
        try {
            this.alert = Driver.initi().switchTo().alert();
            res = true;
        } catch (Exception e) {
        }
        return res;
    }

    public void sendKeys(String text) {
        alert.sendKeys(text);
    }

}
