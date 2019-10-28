package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePage extends BasePage {

    private static final String
            STEP_FREE_ENCYCLOPEDIA = "//XCUIElementTypeStaticText[@name='The free encyclopedia']",
            STEP_NEW_WAYS = "//XCUIElementTypeStaticText[@name='New ways to explore']",
            STEP_300_LANG = "//XCUIElementTypeStaticText[@name='Search in nearly 300 languages']",
            STEP_MAKE_APP_BETTER = "//XCUIElementTypeStaticText[@name='Help make the app better']",
            NEXT_BTN = "//XCUIElementTypeButton[@name='Next']",
            GET_STARTED_BTN = "//XCUIElementTypeButton[@name='Get started']";


    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    public void waitForTheFreeEncyclopedia() {
        waitForElementPresent(By.xpath(STEP_FREE_ENCYCLOPEDIA), "cannot find title free encyclopedia text!", 5);
    }

    public void clickNextBtn() {
        waitForElementPresentAndClick(By.xpath(NEXT_BTN), "cannot find next button!", 5);
    }

    public void waitNewWays() {
        waitForElementPresent(By.xpath(STEP_NEW_WAYS), "cannot find new ways text!", 5);
    }

    public void waitSearch300Languages() {
        waitForElementPresent(By.xpath(STEP_300_LANG), "cannot find search 300 languages text!", 5);
    }

    public void waitHelpMakeBetter() {
        waitForElementPresent(By.xpath(STEP_MAKE_APP_BETTER), "cannot find help make better text!", 5);
    }

    public void clickGetStartedBtn() {
        waitForElementPresentAndClick(By.xpath(GET_STARTED_BTN), "cannot find get started button!", 5);
    }
}
