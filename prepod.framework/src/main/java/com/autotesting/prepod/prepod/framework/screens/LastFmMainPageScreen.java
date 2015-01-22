package com.autotesting.prepod.prepod.framework.screens;

import org.openqa.selenium.By;

public class LastFmMainPageScreen extends CommonPageScreen {

  //урл и локаторы
  private static final String URL = "http://www.last.fm";
  private static final String MAIN_PAGE_TEXT_XPATH = "//h1[@class = 'anon-brand']";
  private static final String UPPER_MUSIC_SEARCH_INPUT_XPATH = "//fieldset/input[@class = 'js-search search-box']";
  private static final String UPPER_SEARCH_BUTTON_XPATH = "//button[@class = 'search-submit icon iconleft iconleft--search']";

  //переход на страницу происходит в конструкторе. там - где он и должен происходить в точке входа в систему (на сайт)
  public LastFmMainPageScreen() {
    log.info(String.format("Open Last.fm page by link: %s", URL));
    driver.get(URL);
  }

  public String getMainPageText() {
    //логируем наши шаги
    log.info(String.format("Get text from page header by xpath: %s", MAIN_PAGE_TEXT_XPATH));
    //получаем текст
    String result = driver.findElementByXPath(MAIN_PAGE_TEXT_XPATH).getText();
    //логируем результат
    log.info(String.format("Result text is: %s", result));
    return result;
  }

  private LastFmMainPageScreen enterTestInSearchInput(String searchText) {
    log.info(String.format("Input text in search input by xpath: %s", UPPER_MUSIC_SEARCH_INPUT_XPATH));
    driver.findElementByXPath(UPPER_MUSIC_SEARCH_INPUT_XPATH).sendKeys(searchText);
    return this;
  }

  private LastFmMainPageScreen clickSearchButton() {
    log.info(String.format("Click on search button by xpath: %s", UPPER_SEARCH_BUTTON_XPATH));
    driver.findElementByXPath(UPPER_SEARCH_BUTTON_XPATH).click();
    return this;
  }

  public SearchResultsPageScreen musicSearch(String searchText) {
    log.info(String.format("Search music by text: %s", searchText));
    enterTestInSearchInput(searchText).clickSearchButton();
    return new SearchResultsPageScreen();
  }

}
