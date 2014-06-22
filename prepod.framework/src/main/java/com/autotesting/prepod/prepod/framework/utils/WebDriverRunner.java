package com.autotesting.prepod.prepod.framework.utils;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotesting.prepod.prepod.framework.utils.WebDriverWrapper;

public class WebDriverRunner {
	private static final Logger log = LoggerFactory.getLogger(WebDriverRunner.class);
	private static WebDriverWrapper driver;
	private static ChromeDriverService service;
	
	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver.exe";
	
	WebDriverRunner() {
		try {
			service = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER)).usingAnyFreePort().build();
			service.start();
			driver = new WebDriverWrapper(service);
		} catch (Exception e) {
			log.error("Error while creating Web Driver", e);
		}
	}
	
	public static WebDriverWrapper getDriver() {
		if(driver == null) {
			new WebDriverRunner();
		}
		return driver;
	}
	
	public static void stopWebDriver() {
		driver.quit();
		service.stop();
	}
}
