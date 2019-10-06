package tests;

import lib.BaseTest;
import lib.ui.SearchPage;
import org.junit.Test;

public class SearchTests extends BaseTest {

    @Test
    public void testCheckSearchTip() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.checkSearchTip();
    }

    @Test
    public void testCheckSearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Java");
        searchPage.waitSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.waitForCancelSearchBtnToAppear();
        searchPage.clickCancelSearchBtn();
        searchPage.waitForCancelSearchBtnToDisappear();
    }

    @Test
    public void testCheckSearchDisplaysFewArticlesAndCancelSearch() {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine("Java");

        Integer articlesCount = searchPage.getSearchResultsCount();
        assertTrue("Wiki can't find more than 2 articles about this =(", articlesCount > 2);

        searchPage.clickCancelSearchBtn();
        String search_empty_title = searchPage.getEmptySearchTitle();
        assertEquals("We see unexpected search empty title!", "Search and read the free encyclopedia in your language", search_empty_title);
    }

    @Test
    public void testCheckAllFoundArticlesContainSearchKey() {
        String keyword = "Java";
        SearchPage searchPage = new SearchPage(driver);
        searchPage.initSearchInput();
        searchPage.typeSearchLine(keyword);

        Boolean allArticlesHasKeyword = searchPage.checkAllSearchResultsHaveKeyword(keyword);
        assertTrue("Some articles doesnt contain selected keyword: " + keyword, allArticlesHasKeyword);
    }

}
