package com.autotesting.prepod.prepod.framework.suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.prepod.prepod.framework.screens.TutByMainPageScreen;


public class TutByTest 
{

	public static final String VALID_USERNAME = "qweqweqwe1231234@tut.by";
	public static final String VALID_PASSWORD = "qweqweqwe123123";
	
	@Test
	public void authorization() {
		TutByMainPageScreen tutByPage = new TutByMainPageScreen();
		tutByPage.login(VALID_USERNAME, VALID_PASSWORD);
	}
	
	@Test
	public void authorization2() {
		TutByMainPageScreen tutByPage = new TutByMainPageScreen();
		tutByPage.login(VALID_USERNAME, VALID_PASSWORD);
	}
}
