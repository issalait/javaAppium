package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {

    private static final String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            TITLE_2 = "id:org.wikipedia:id/view_page_title_textttt",
            FOOTER = "xpath://*[@text='View page in browser']",
            ARTICLE_OPTIONS_BTN = "xpath://android.widget.ImageView[@content-desc='More options']",
            ADD_TO_READING_LIST_OPTION = "xpath://*[@text='Add to reading list']",
            ADD_TO_READING_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            READING_LIST_NAME = "id:org.wikipedia:id/text_input",
            READING_LIST_OK_BTN = "xpath://*[@text='OK']",
            ARTICLE_CLOSE_BTN = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            EXISTING_READING_LIST_TPL = "xpath://*[@text='{LIST_NAME}']";

    private static String getReadingListNameXpath(String readingListName) {
        return EXISTING_READING_LIST_TPL.replace("{LIST_NAME}", readingListName);
    }

    public ArticlePage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return waitForElementPresent(TITLE, "Cant find article title!", 5);
    }

    public Boolean checkArticleHasTitle() throws Exception {
        try {
            WebElement article_title = checkElementPresent(TITLE);
            return true;
        } catch (Exception e) {
            System.out.println("Article hasn't title element");
            return false;
        }
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        swipeToFindElements(FOOTER, "Can't find the end of the article!", 10);
    }

    public void addArticleToReadingList(String readingListName) {
        waitForElementPresentAndClick(ARTICLE_OPTIONS_BTN,
                "cannot find article options btn",
                5);
        waitForElementPresentAndClick(ADD_TO_READING_LIST_OPTION,
                "cannot find Add to reading list option",
                5);
        waitForElementPresentAndClick(ADD_TO_READING_LIST_OVERLAY,
                "cannot find Got it tip overlay",
                5);
        waitForElementPresentAndClear(READING_LIST_NAME,
                "cant find input to set my reading list name ",
                5);
        waitForElementPresentAndSendKeys(READING_LIST_NAME,
                "cant put text into my reading list name input",
                5,
                readingListName);
        waitForElementPresentAndClick(READING_LIST_OK_BTN,
                "cannot press ok btn",
                5);
    }

    public void addArticleToExistingReadingList(String readingListName) {
        waitForElementPresentAndClick(ARTICLE_OPTIONS_BTN,
                "cannot find article options btn",
                5);
        waitForElementPresentAndClick(ADD_TO_READING_LIST_OPTION,
                "cannot find Add to reading list option",
                5);
        String readingListItemXpath = getReadingListNameXpath(readingListName);
        waitForElementPresentAndClick(readingListItemXpath,
                "cannot find and click reading list with name " + readingListName,
                7);
    }

    public void closeArticle() {
        waitForElementPresentAndClick(ARTICLE_CLOSE_BTN,
                "cannot close article, cant find X btn",
                6);
    }

}
