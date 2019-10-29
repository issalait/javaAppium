package tests;

import lib.BaseTest;
import lib.ui.WelcomePage;
import org.junit.Test;

public class GetStartedTest extends BaseTest {

    @Test
    public void testPassWelcome() {
        if (this.Platform.isAndroid()) {
            return;
        }
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.waitForTheFreeEncyclopedia();
        welcomePage.clickNextBtn();

        welcomePage.waitNewWays();
        welcomePage.clickNextBtn();

        welcomePage.waitSearch300Languages();
        welcomePage.clickNextBtn();

        welcomePage.waitHelpMakeBetter();
        welcomePage.clickGetStartedBtn();
    }
}
