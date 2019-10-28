package tests.iOS;

import lib.IosBaseTest;
import lib.ui.WelcomePage;
import org.junit.Test;

public class GetStartedTest extends IosBaseTest {

    @Test
    public void testPassWelcome() {
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
