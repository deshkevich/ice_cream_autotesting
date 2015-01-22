package com.autotesting.prepod.prepod.framework.screens;

public class SearchResultsPageScreen extends CommonPageScreen {

  private static final String TOP_HIT_RESULT_XPATH = "//div[@class = 'result']/h3/a";

  public SearchResultsPageScreen() {}

  public String getTopHitResultText() {
    log.info(String.format("Get text from search results by xpath: %s", TOP_HIT_RESULT_XPATH));
    String result = driver.findElementByXPath(TOP_HIT_RESULT_XPATH).getText();
    log.info(String.format("Result text is: %s", result));
    return result;
  }

  public ArtistPageScreen goToResultPage() {
    log.info(String.format("Go to artist page by link with xpath: %s", TOP_HIT_RESULT_XPATH));
    driver.findElementByXPath(TOP_HIT_RESULT_XPATH).click();
    return new ArtistPageScreen();
  }
}
