package com.autotesting.prepod.prepod.framework.screens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotesting.prepod.prepod.framework.utils.*;

public class CommonPageScreen {

  //логгер и вебдрайвер - protected. значит во всех наследниках CommonPageScreen они будут использоваться
  protected WebDriverWrapper driver;
  protected final Logger log = LoggerFactory.getLogger(CommonPageScreen.class);

  public CommonPageScreen() {
    driver = WebDriverRunner.getDriver();
  }

  public void closePage() {
    log.debug("Закрываем браузер.");
    WebDriverRunner.stopWebDriver();
  }
}
