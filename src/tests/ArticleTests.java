package tests;

import lib.BaseTest;
import lib.ui.ArticlePage;
import lib.ui.SearchPage;
import org.junit.Test;

public class ArticleTests extends BaseTest {

    @Test
    public void testCompareArticleTitle() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Java");
        searchPage.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePage articlePage = new ArticlePage(driver);
        String article_title = articlePage.getArticleTitle();
        assertEquals("We see unexpected title!", "Java (programming language)", article_title);
    }

    @Test
    public void testFastCheckArticleHasTitle() throws Exception {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Appium");
        searchPage.clickByArticleWithSubstring("Appium");

        ArticlePage articlePage = new ArticlePage(driver);
        Boolean has_titile = articlePage.checkArticleHasTitle();
        assertTrue(has_titile);

    }

    @Test
    public void testSwipeArticle() {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Appium");
        searchPage.clickByArticleWithSubstring("Appium");

        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.waitForTitleElement();
        articlePage.swipeToFooter();
    }
}
