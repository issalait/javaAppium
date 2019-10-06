package tests;

import lib.BaseTest;
import lib.ui.ArticlePage;
import lib.ui.MyListsPage;
import lib.ui.NavigationUI;
import lib.ui.SearchPage;
import org.junit.Test;

public class MyListsTests extends BaseTest {

    @Test
    public void testAddFirstArticleToMyList() {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Java");
        searchPage.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.waitForTitleElement();
        String article_title = articlePage.getArticleTitle();
        String myReadingName = "programming";

        articlePage.addArticleToReadingList(myReadingName);
        articlePage.closeArticle();

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.OpenMyLists();

        MyListsPage myListsPage = new MyListsPage(driver);
        myListsPage.openListByName(myReadingName);
        myListsPage.deleteItemFromReadingListBySwipe(article_title);
    }

    @Test
    public void testSaveTwoArticlesDeleteOneArticle() {

        String myReadingName = "programming";

        SearchPage searchPage = new SearchPage(driver);
        //search first article
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Java");
        searchPage.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.waitForTitleElement();
        //add first article to reading list
        String article_title = articlePage.getArticleTitle();
        articlePage.addArticleToReadingList(myReadingName);
        articlePage.closeArticle();

        //search second article
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Appium");
        searchPage.clickByArticleWithSubstring("Appium");

        articlePage.waitForTitleElement();
        //add second article to reading list
        String second_article_title = articlePage.getArticleTitle();
        articlePage.addArticleToExistingReadingList(myReadingName);
        articlePage.closeArticle();

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.OpenMyLists();

        MyListsPage myListsPage = new MyListsPage(driver);
        myListsPage.openListByName(myReadingName);
        myListsPage.deleteItemFromReadingListBySwipe(second_article_title);
        myListsPage.checkReadingListItemApeared(article_title);
        myListsPage.openSavedArticleByName(article_title);

        String opened_article_title = articlePage.getArticleTitle();
        assertEquals("opened article is not equal with" + article_title, article_title, opened_article_title);
    }
}
