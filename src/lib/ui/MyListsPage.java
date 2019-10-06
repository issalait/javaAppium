package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPage extends BasePage {

    private static final String
            READING_LIST_NAME_TPL = "//*[@text='(LIST_NAME}']",
            READING_LIST_ITEM_NAME_TPL = "//*[@text='(ITEM_NAME}']";

    private static String getListNameXpath(String readingListName) {
        return READING_LIST_NAME_TPL.replace("(LIST_NAME}", readingListName);
    }

    private static String getItemNameXpath(String readingListItemName) {
        return READING_LIST_ITEM_NAME_TPL.replace("(ITEM_NAME}", readingListItemName);
    }

    public MyListsPage(AppiumDriver driver) {
        super(driver);
    }

    public void openListByName(String readingListName) {
        String listXpath = getListNameXpath(readingListName);
        waitForElementPresentAndClick(By.xpath(listXpath),
                "cannot click reading list by name +" + readingListName,
                7);
    }

    public void deleteItemFromReadingListBySwipe(String readingListItemName) {
        checkReadingListItemApeared(readingListItemName);
        String readingListItemXpath = getItemNameXpath(readingListItemName);
        swipeElementToLeft(By.xpath(readingListItemXpath),
                "cannot delete article from reading list");
        checkReadingListItemDissapeared(readingListItemName);
    }

    public void checkReadingListItemDissapeared(String readingListItemName) {
        String readingListItemXpath = getItemNameXpath(readingListItemName);
        waitForElementNotPresent(By.xpath(readingListItemXpath),
                "article is still present in the reading list", 5);
    }

    public void checkReadingListItemApeared(String readingListItemName) {
        String readingListItemXpath = getItemNameXpath(readingListItemName);
        waitForElementPresent(By.xpath(readingListItemXpath),
                "article is not present in the reading list", 5);
    }

    public void openSavedArticleByName(String article_name) {
        waitForElementPresentAndClick(By.xpath(getItemNameXpath(article_name))
                , "article is not present in the reading list"
                , 5);
    }
}
