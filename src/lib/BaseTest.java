package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.Platform;
import org.openqa.selenium.ScreenOrientation;

public class BaseTest extends TestCase {
    protected AppiumDriver driver;
    protected lib.ui.Platform Platform;

    @Override
    protected void setUp() throws Exception {

        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();

        rotateScreenToPortrait();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenToPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenToLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void runAppInBackground(int seconds) {
        driver.runAppInBackground(seconds);
    }

}
