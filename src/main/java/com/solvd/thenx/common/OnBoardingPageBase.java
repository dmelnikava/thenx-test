package com.solvd.thenx.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class OnBoardingPageBase extends AbstractPage {

	public OnBoardingPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract boolean isPageOpened();

	public abstract void selectFemaleSex();

	public abstract void clickNextBtn();

	public abstract void clickCmHeightPicker();

	public abstract void swipeFor164Height(int startXValue, int startYValue, int endXValue, int endYValue, int duration);

	public abstract void clickKgWeightPicker();

	public abstract void swipeFor64Weight(int startXValue, int startYValue, int endXValue, int endYValue, int duration);

	public abstract void clickFitnessBeginnerLevel();

	public abstract boolean getFitnessBeginnerLevelCheck();

	public abstract void clickBuildMuscleGoal();

	public abstract boolean getBuildMuscleGoalCheck();

	public abstract void typePullup(String pullup);

	public abstract void typePushup(String pushup);

	public abstract void typeSquat(String squat);

	public abstract void typeDip(String dip);

	public abstract void typeUsername(String username);

	public abstract void typeFullName(String fullName);

	public abstract void typeEmail(String email);

	public abstract void typePassword(String password);

	public abstract boolean isLoginBtnActive();

	public abstract HomePageBase clickLoginBtn();

	public abstract HomePageBase login(int startXValue, int startYValue, int endXValue, int endYValue, int duration,
									   String pullup, String pushup, String squat, String dip, String username, String fullName, String email, String password);

}
