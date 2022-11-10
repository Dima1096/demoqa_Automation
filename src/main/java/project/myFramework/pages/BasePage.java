package project.myFramework.pages;

import org.apache.log4j.Logger;
import project.myFramework.elements.BaseElement;

public abstract class BasePage {
    final static Logger log = Logger.getLogger(BasePage.class);
    private BaseElement uniqEl;

    public BasePage(BaseElement element) {
        this.uniqEl = element;

    }

    public boolean isOpen() {
        boolean res = uniqEl.isDisplayed();
        log.info(uniqEl.getName() + " is open " + res);
        return res;
    }

}
