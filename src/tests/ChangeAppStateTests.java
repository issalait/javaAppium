package tests;

import lib.BaseTest;
import lib.ui.ArticlePage;
import lib.ui.SearchPage;
import org.junit.Test;

public class ChangeAppStateTests extends BaseTest {

    @Test
    public void testCheckSearchResultsAfterRotate() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Java");
        searchPage.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.waitForTitleElement();
        String title_before_rotation = articlePage.getArticleTitle();
        rotateScreenToPortrait();

        String title_after_rotation = articlePage.getArticleTitle();
        assertEquals("Article title has been changed after rotation"
                , title_before_rotation
                , title_after_rotation);
        rotateScreenToLandscape();

        String title_after_second_rotation = articlePage.getArticleTitle();
        assertEquals("Article title has been changed after second rotation"
                , title_before_rotation
                , title_after_second_rotation);
        rotateScreenToLandscape();
    }

    @Test
    public void testCheckAppAfterBackground() {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Java");
        searchPage.waitSearchResult("Object-oriented programming language");
        runAppInBackground(2);
        searchPage.waitSearchResult("Object-oriented programming language");
    }
}
