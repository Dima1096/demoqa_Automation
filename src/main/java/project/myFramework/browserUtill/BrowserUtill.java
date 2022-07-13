package project.myFramework.browserUtill;

import project.myFramework.driver.*;
import io.github.bonigarcia.*;

public class BrowserUtill {
    public static String getIdWindows(){
        return Driver.initi().getWindowHandle();
    }

    public static int numberOfWindows(){
        return Driver.initi().getWindowHandles().size();
    }

    public static void switchToNewWindow(String originalWindow) {
        for (String windowHandle : Driver.initi().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                Driver.initi().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void get(String url){
        Driver.initi().get(url);
    }

}

