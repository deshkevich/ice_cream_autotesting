package com.autotesting.prepod.prepod.framework.suits;

import com.autotesting.prepod.prepod.framework.screens.LastFmMainPageScreen;
import com.autotesting.prepod.prepod.framework.screens.SearchResultsPageScreen;
import com.autotesting.prepod.prepod.framework.utils.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LastFmSearchTest {

  //здесь мы описываем входные данные для теста. Естественно они константы
  public static final String MAIN_PAGE_HEADER_TEXT = "Discover more music";
  public static final String ARTIST_SEARCH_REQUEST_TEXT = "Александр Солодуха";
  public static final String TRACK_SEARCH_REQUEST_TEXT = "Здравствуй чужая милая";

    @DataProvider
    public static Object[][] langs() {
        return new Object[][]{{1, 2}, {2, 3}};
    }


  @Test(description = "Verify that artist search result match with request")
  public void artistSearchTest() {
    //создаем экземпляр стартовой страницы. В конструкторе происходит переход по урлу
    LastFmMainPageScreen lastFmPage = new LastFmMainPageScreen();
    //проверяем, что страница открылась, если виден текст на стартовой странице
    Assert.assertEquals(lastFmPage.getMainPageText(), MAIN_PAGE_HEADER_TEXT,
        "Header text not match with expected value");
    //набираем поисковый запрос и переходим на страницу поиска. поскольку метод musicSearch должен возвращать объект страницы
    //с результатиами поиска - создаем под это дело SearchResultsPageScreen searchPage
    SearchResultsPageScreen searchPage = lastFmPage.musicSearch(ARTIST_SEARCH_REQUEST_TEXT);
    //проверяем, что самый релевантный результат поиска - это то, что мы вводили в строку. таким образом мы проверяем не только юай,
    //но и "точность" поисковой машины
    Assert.assertEquals(searchPage.getTopHitResultText(), ARTIST_SEARCH_REQUEST_TEXT,
        "Search results not match with search request");
  }

  @Test(description = "Verify that track search result match with artist")
  public void trackSearchTest() {
    LastFmMainPageScreen lastFmPage = new LastFmMainPageScreen();
    SearchResultsPageScreen searchPage = lastFmPage.musicSearch(TRACK_SEARCH_REQUEST_TEXT);
    Assert.assertTrue(searchPage.getTopHitResultText().contains(ARTIST_SEARCH_REQUEST_TEXT),
        "Founded track not matched with artist");
  }

  @AfterTest
  public void tearDown() {
    //закрываем браузер. в этом случае обращаться к драйверу можно (но не напрямую, как видите)
    WebDriverRunner.stopWebDriver();
  }
}
