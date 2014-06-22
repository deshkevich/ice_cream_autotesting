package com.autotesting.prepod.prepod.framework.screens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotesting.prepod.prepod.framework.utils.*;

public class CommonPageScreen {
	
    protected WebDriverWrapper driver = WebDriverRunner.getDriver();
    protected final Logger log = LoggerFactory.getLogger(CommonPageScreen.class);
	
	public void closePage() {
		log.debug("Закрываем браузер.");
		WebDriverRunner.stopWebDriver();
	}
}
