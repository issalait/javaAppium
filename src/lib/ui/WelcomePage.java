package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePage extends BasePage {

    private static final String
            STEP_FREE_ENCYCLOPEDIA = "xpath://XCUIElementTypeStaticText[@name='The free encyclopedia']",
            STEP_NEW_WAYS = "xpath://XCUIElementTypeStaticText[@name='New ways to explore']",
            STEP_300_LANG = "xpath://XCUIElementTypeStaticText[@name='Search in nearly 300 languages']",
            STEP_MAKE_APP_BETTER = "xpath://XCUIElementTypeStaticText[@name='Help make the app better']",
            NEXT_BTN = "xpath://XCUIElementTypeButton[@name='Next']",
            GET_STARTED_BTN = "xpath://XCUIElementTypeButton[@name='Get started']";


    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    public void waitForTheFreeEncyclopedia() {
        waitForElementPresent(STEP_FREE_ENCYCLOPEDIA, "cannot find title free encyclopedia text!", 5);
    }

    public void clickNextBtn() {
        waitForElementPresentAndClick(NEXT_BTN, "cannot find next button!", 5);
    }

    public void waitNewWays() {
        waitForElementPresent(STEP_NEW_WAYS, "cannot find new ways text!", 5);
    }

    public void waitSearch300Languages() {
        waitForElementPresent(STEP_300_LANG, "cannot find search 300 languages text!", 5);
    }

    public void waitHelpMakeBetter() {
        waitForElementPresent(STEP_MAKE_APP_BETTER, "cannot find help make better text!", 5);
    }

    public void clickGetStartedBtn() {
        waitForElementPresentAndClick(GET_STARTED_BTN, "cannot find get started button!", 5);
    }
}
