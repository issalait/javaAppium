package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    protected final static String
            SEARCH_INIT_ELEMENT = "org.wikipedia:id/search_container",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_CANCEL_BTN = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_RESULTS = "org.wikipedia:id/page_list_item_container",
            SEARCH_RESULT_TITLE = "org.wikipedia:id/page_list_item_title",
            SEARCH_EMPTY = "org.wikipedia:id/search_empty_message";

    //TPL methods here
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_TPL.replace("{SUBSTRING}", substring);
    }

    //end of TPL methods

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        waitForElementPresentAndClick(By.id(SEARCH_INIT_ELEMENT), "Cannot find Search Wikipedia input!", 5);
        waitForElementPresent(By.id(SEARCH_INPUT), "Cannot find search input!", 5);
    }

    public void waitForCancelSearchBtnToAppear() {
        waitForElementPresent(By.id(SEARCH_CANCEL_BTN), "Cannot find X to cancel search", 5);
    }

    public void waitForCancelSearchBtnToDisappear() {
        waitForElementNotPresent(By.id(SEARCH_CANCEL_BTN), "cancel search btn is still present", 5);
    }

    public void clickCancelSearchBtn() {
        waitForElementPresentAndClick(By.id(SEARCH_CANCEL_BTN), "Cannot click X to cancel search", 5);
    }

    public void typeSearchLine(String searchQuery) {
        waitForElementPresentAndSendKeys(By.id(SEARCH_INPUT), "Cannot find search input!", 5, searchQuery);
    }

    public void waitSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementPresentAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring, 5);
    }

    public void checkSearchTip() {
        String search_tip = waitForElementAndGetAttribute(By.id(SEARCH_INPUT), "text", "Cannot find search input!", 5);
        Assert.assertEquals("We see unexpected search tip!", "Search…", search_tip);
    }

    public Integer getSearchResultsCount() {
        return getWebElementsCount(By.id(SEARCH_RESULTS),
                "Cannot find any articles",
                3);
    }

    public String getEmptySearchTitle() {
        return waitForElementAndGetAttribute(By.id(SEARCH_EMPTY),
                "text",
                "Cannot find empty search element!",
                3);
    }

    public Boolean checkAllSearchResultsHaveKeyword(String keyword) {
        return checkWebElemensListContainsWordInText(By.id(SEARCH_RESULT_TITLE),
                "Cannot find any articles with keyword " + keyword,
                3,
                keyword);
    }

}
