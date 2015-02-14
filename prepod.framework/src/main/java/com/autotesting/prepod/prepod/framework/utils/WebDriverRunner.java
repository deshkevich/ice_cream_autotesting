package com.autotesting.prepod.prepod.framework.utils;

import java.io.File;
import java.net.URL;

import com.sun.glass.ui.View;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotesting.prepod.prepod.framework.utils.WebDriverWrapper;

public class WebDriverRunner {
  private static final Logger log = LoggerFactory.getLogger(WebDriverRunner.class);
  private static WebDriverWrapper driver;
  private static ChromeDriverService service;

  //адрес к хромдрайверу для виндовс
  private static final String PATH_TO_CHROMEDRIVER_WIN = "resource//chromedriver.exe";
  //адрес для линукс
  //private static final String PATH_TO_CHROMEDRIVER_NIX = "resource//chromedriver";

  WebDriverRunner() {
    try {
/*      service = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER_WIN)).usingAnyFreePort().build();
      service.start();*/

        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setCapability("platform", Platform.WINDOWS);
        driver = new WebDriverWrapper(new URL("http://localhost:4444/wd/hub"), capability);
    } catch (Exception e) {
      log.error("Error while creating Web Driver", e);
    }
  }

  public static WebDriverWrapper getDriver() {
    //если объекта драйвера нет, то создаем его. если есть - возвращаем этим методом существующий
    if (driver == null) {
      new WebDriverRunner();
    }
    return driver;
  }

  public static void stopWebDriver() {
    driver.quit();
    service.stop();
  }
}
