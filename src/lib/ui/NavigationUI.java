package lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends BasePage {

    private static final String
            MY_LISTS_BTN = "xpath://android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void OpenMyLists() {
        waitForElementPresentAndClick(MY_LISTS_BTN,
                "cannot find My lists btn",
                5);
    }

}
