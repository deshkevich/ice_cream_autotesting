package com.autotesting.prepod.prepod.framework.screens;

import org.openqa.selenium.By;

public class TutByMainPageScreen extends CommonPageScreen {

	public static final String OPEN_LOGIN_FORM_BUTTON_XPATH = "//a[@data-target-popup='authorize-formdddd']";
	public static final String USERNAME_INPUT_XPATH = "//input[@name = 'login']";
	public static final String PASSWORD_INPUT_XPATH =  "//input[@name = 'password']";
	public static final String ENTER_INBOX_BUTTON_XPATH =  "//input[@value = 'Войти']";
	public static final String URL = "http://www.tut.by";
	
	
	public TutByMainPageScreen() {
		driver.get(URL);
	}
	
	public TutByMainPageScreen login(String username, String password) {
		driver.clickByXpath(OPEN_LOGIN_FORM_BUTTON_XPATH);
		driver.findElement(By.xpath(USERNAME_INPUT_XPATH)).sendKeys(username);
		driver.findElement(By.xpath(PASSWORD_INPUT_XPATH)).sendKeys(password);
		driver.findElement(By.xpath(ENTER_INBOX_BUTTON_XPATH)).click();
		
		return this;
	}
	
}
