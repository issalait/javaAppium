import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/JavaAppiumAuto/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckSearchTip() {
        waitForElementPresentAndClick(By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input!",
                3);
        WebElement search_input = waitForElementPresent(By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search input!",
                2);
        String search_tip = search_input.getAttribute("text");
        Assert.assertEquals("We see unexpected search tip!", "Search…", search_tip);
    }

    @Test
    public void firstTest() {
        waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find Search Wikipedia input!",
                2);

        waitForElementPresentAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Cannot find search input!",
                3,
                "Java");

        waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "cannot find Object-oriented programming language",
                3);
    }

    @Test
    public void testCancelSearch() {
        waitForElementPresentAndClick(By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input!",
                3);
        waitForElementPresentAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Cannot find search input!",
                3,
                "Java");
        waitForElementPresentAndClear(By.id("org.wikipedia:id/search_src_text"),
                "Cannot clear search input!", 2);
        waitForElementPresentAndClick(By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X to cancel search",
                2);
        waitForElementNotPresent(By.id("org.wikipedia:id/search_close_btn"),
                "X is still visible!",
                3);
    }

    @Test
    public void testCompareArticleTitle() {
        waitForElementPresentAndClick(By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input!",
                8);
        waitForElementPresentAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Cannot find search input!",
                3,
                "Java");
        waitForElementPresentAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "cannot find Object-oriented programming language",
                3);
        WebElement title_element = waitForElementPresent(By.id("org.wikipedia:id/view_page_title_text"),
                "Cant find this article",
                3);
        String article_title = title_element.getAttribute("text");
        Assert.assertEquals("We see unexpected title!", "Java (programming language)", article_title);
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 2);
    }

    private WebElement waitForElementPresentAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementPresentAndSendKeys(By by, String error_message, long timeoutInSeconds, String value) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private WebElement waitForElementPresentAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
