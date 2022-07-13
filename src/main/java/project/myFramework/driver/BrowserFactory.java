package project.myFramework.driver;

import org.openqa.selenium.firefox.FirefoxProfile;
import project.config.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import project.config.JsonParser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    public WebDriver createDriver(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case ("chrome"):
                driver = createChromeDriver();
                break;
            case ("firefox"):
                driver = createFirefoxDriver();
                break;
            case ("edge"):
                driver = createEdgeDriver();
                break;
            case ("safari"):
                driver = createSafariDriver();
                break;
            case ("opera"):
                driver = createOperaDriver();
                break;
        }
        return driver;
    }

    public WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getChromeOptions());
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();


        if (JsonParser.Incognito().toLowerCase().equals("true")) {
            chromeOptions.addArguments("--incognito");
        }
        if (JsonParser.startMaximized().toLowerCase().equals("true")) {
            chromeOptions.addArguments("start-maximized");
        }
        switch (JsonParser.browserLanguage().toLowerCase()) {
            case ("english"):
                chromeOptions.addArguments("--lang=en-en");
                break;
            case ("русский"):
                chromeOptions.addArguments("--lang=ru-ru");
                break;
            default:
              throw   new BrowserLanguageException(JsonParser.browserLanguage() + " language is not supported");


        }

        Map<String, Object> p = new HashMap<String, Object>();
        p.put("download.default_directory", System.getProperty("user.dir") + File.separator +"files");
        chromeOptions.setExperimentalOption("prefs", p);
        return chromeOptions;
    }

    public WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();

        return new FirefoxDriver(getFirefoxOptions());
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (JsonParser.Incognito().toLowerCase().equals("true")) {
            firefoxOptions.addArguments("-private");
        }

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir",System.getProperty("user.dir") + File.separator+"files" );
        firefoxOptions.setProfile(profile);

        return firefoxOptions;
    }

    public WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();

        return new EdgeDriver(getEdgeOptions());
    }

    public EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (JsonParser.Incognito().toLowerCase().equals("true")) {
            edgeOptions.addArguments("-inprivate");
        }
        return edgeOptions;
    }

    public WebDriver createSafariDriver() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver(getSafariOptions());
    }


    public SafariOptions getSafariOptions() {
        SafariOptions safariOptions = new SafariOptions();

        return safariOptions;
    }

    public WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();

        return new OperaDriver(getOperaOptions());
    }


    public OperaOptions getOperaOptions() {
        OperaOptions operaOptions = new OperaOptions();
        if (JsonParser.Incognito().toLowerCase().equals("true")) {
            operaOptions.addArguments("private");
        }

        return operaOptions;

    }
}

class BrowserLanguageException extends Error {
    public BrowserLanguageException(String message) {
        super(message);
    }

}
