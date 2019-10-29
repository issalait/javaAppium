package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

public class SearchPage extends BasePage {

    protected final static String
            SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/search_container",
            SEARCH_INPUT = "id:org.wikipedia:id/search_src_text",
            SEARCH_CANCEL_BTN = "id:org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_RESULTS = "id:org.wikipedia:id/page_list_item_container",
            SEARCH_RESULT_TITLE = "id:org.wikipedia:id/page_list_item_title",
            SEARCH_EMPTY = "id:org.wikipedia:id/search_empty_message";

    //TPL methods here
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_TPL.replace("{SUBSTRING}", substring);
    }

    //end of TPL methods

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        waitForElementPresentAndClick(SEARCH_INIT_ELEMENT, "Cannot find Search Wikipedia input!", 5);
        waitForElementPresent(SEARCH_INPUT, "Cannot find search input!", 5);
    }

    public void waitForCancelSearchBtnToAppear() {
        waitForElementPresent(SEARCH_CANCEL_BTN, "Cannot find X to cancel search", 5);
    }

    public void waitForCancelSearchBtnToDisappear() {
        waitForElementNotPresent(SEARCH_CANCEL_BTN, "cancel search btn is still present", 5);
    }

    public void clickCancelSearchBtn() {
        waitForElementPresentAndClick(SEARCH_CANCEL_BTN, "Cannot click X to cancel search", 5);
    }

    public void typeSearchLine(String searchQuery) {
        waitForElementPresentAndSendKeys(SEARCH_INPUT, "Cannot find search input!", 5, searchQuery);
    }

    public void waitSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementPresentAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 5);
    }

    public void checkSearchTip() {
        String search_tip = waitForElementAndGetAttribute(SEARCH_INPUT, "text", "Cannot find search input!", 5);
        Assert.assertEquals("We see unexpected search tip!", "Search…", search_tip);
    }

    public Integer getSearchResultsCount() {
        return getWebElementsCount(SEARCH_RESULTS,
                "Cannot find any articles",
                3);
    }

    public String getEmptySearchTitle() {
        return waitForElementAndGetAttribute(SEARCH_EMPTY,
                "text",
                "Cannot find empty search element!",
                3);
    }

    public Boolean checkAllSearchResultsHaveKeyword(String keyword) {
        return checkWebElementsListContainsWordInText(SEARCH_RESULT_TITLE,
                "Cannot find any articles with keyword " + keyword,
                3,
                keyword);
    }

}
