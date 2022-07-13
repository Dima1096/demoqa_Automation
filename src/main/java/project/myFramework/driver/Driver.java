package project.myFramework.driver;

import project.config.*;
import org.openqa.selenium.WebDriver;
import project.config.JsonParser;


public class Driver {


    private static WebDriver driver = null;

    public static void quiteDriver() {
        driver.quit();
        Driver.driver = null;
    }

    public static WebDriver initi() {
        if (driver == null) {
            BrowserFactory factory = new BrowserFactory();
            driver = factory.createDriver(JsonParser.BrowserName().toLowerCase());
        }
        return driver;
    }


}



