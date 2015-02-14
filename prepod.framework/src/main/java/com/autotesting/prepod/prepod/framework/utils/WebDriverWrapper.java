package com.autotesting.prepod.prepod.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotesting.prepod.prepod.framework.screens.CommonPageScreen;

import java.net.URL;

public class WebDriverWrapper extends RemoteWebDriver {

  protected final Logger log = LoggerFactory.getLogger(CommonPageScreen.class);
  public static final int TIMEOUT_FOR_ACTION_SECONDS = 5;

  public WebDriverWrapper(URL remoteUrl, Capabilities capabilities) {
    super(remoteUrl, capabilities);
  }

  public void clickByXpath(String xpath) {
    log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
    findElement(By.xpath(xpath)).click();
  }

  public void clickByXpath(String xpath, int timeout) {
    log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
    waitForElementPresentAndVisible(xpath, timeout);
    waitForElementClickable(xpath, timeout);
    findElement(By.xpath(xpath)).click();
  }

  private void waitForElementPresentAndVisible(String locator, int timeout) {
    WebDriverWait wait = new WebDriverWait(this, timeout);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }

  private void waitForElementClickable(String locator, int timeout) {
    WebDriverWait wait = new WebDriverWait(this, timeout);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
  }

  public String getTextByXpath(String xpath) {
    log.debug(String.format("[ACTION]: Get element text by xpath: '%s'", xpath));
    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
    String result = findElement(By.xpath(xpath)).getText();
    log.debug(String.format("[ACTION]: Text in founded element is: '%s'", result));
    return result;
  }

  public void enterTextByXpath(String xpath, String text) {
    log.debug(String.format("[ACTION]: Enter text '%s' in element by xpath: '%s'", text, xpath));
    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
    findElement(By.xpath(xpath)).sendKeys(text);
  }

}
