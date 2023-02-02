package com.solvd.thenx.android;

import com.solvd.thenx.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.OnBoardingPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = OnBoardingPageBase.class)
public class OnBoardingPage extends OnBoardingPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/gender_picker_female")
    private ExtendedWebElement femaleBtn;

    @FindBy(id = "com.sysops.thenx:id/on_boarding_next")
    private ExtendedWebElement nextBtn;

    @FindBy(id = "com.sysops.thenx:id/height_picker_cm")
    private ExtendedWebElement heightPicker;

    @FindBy(id = "android:id/numberpicker_input")
    private ExtendedWebElement numberPicker;

    @FindBy(id = "com.sysops.thenx:id/weight_picker_kg")
    private ExtendedWebElement weightPicker;

    @FindBy(id = "com.sysops.thenx:id/fitness_level_beginner")
    private ExtendedWebElement fitnessBeginnerLevel;

    @FindBy(id = "com.sysops.thenx:id/fitness_level_beginner_check")
    private ExtendedWebElement fitnessBeginnerLevelCheck;

    @FindBy(id = "com.sysops.thenx:id/goals_build_muscle")
    private ExtendedWebElement buildMuscleGoal;

    @FindBy(id = "com.sysops.thenx:id/goals_build_muscle_check")
    private ExtendedWebElement buildMuscleGoalCheck;

    @FindBy(id = "com.sysops.thenx:id/performance_max_pullups_input")
    private ExtendedWebElement maxPullup;

    @FindBy(id = "com.sysops.thenx:id/performance_max_pushups_input")
    private ExtendedWebElement maxPushup;

    @FindBy(id = "com.sysops.thenx:id/performance_max_squats_input")
    private ExtendedWebElement maxSquat;

    @FindBy(id = "com.sysops.thenx:id/performance_max_dips_input")
    private ExtendedWebElement maxDip;

    @FindBy(id = "com.sysops.thenx:id/register_username")
    private ExtendedWebElement registerUsername;

    @FindBy(id = "com.sysops.thenx:id/register_fullname")
    private ExtendedWebElement registerFullName;

    @FindBy(id = "com.sysops.thenx:id/register_email")
    private ExtendedWebElement registerEmail;

    @FindBy(id = "com.sysops.thenx:id/register_password")
    private ExtendedWebElement registerPassword;

    public OnBoardingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return nextBtn.isElementPresent();
    }

    @Override
    public void selectFemaleSex() {
        femaleBtn.click();
    }

    @Override
    public void clickNextBtn() {
        nextBtn.click();
    }

    @Override
    public void clickCmHeightPicker() {
        heightPicker.click();
    }

    @Override
    public void swipeFor164Height(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        swipe(startXValue,startYValue, endXValue, endYValue, duration);
        swipe(startXValue,startYValue, endXValue, endYValue, duration);
        swipe(startXValue,startYValue, endXValue, endYValue, duration);
    }

    @Override
    public void clickKgWeightPicker() {
        weightPicker.click();
    }

    @Override
    public void swipeFor64Weight(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        swipe(startXValue,startYValue, endXValue, endYValue, duration);
        swipe(startXValue,startYValue, endXValue, endYValue, duration);
        swipe(startXValue,startYValue, endXValue, endYValue, duration);
    }

    @Override
    public void clickFitnessBeginnerLevel() {
        fitnessBeginnerLevel.click();
    }

    @Override
    public boolean getFitnessBeginnerLevelCheck() {
        return fitnessBeginnerLevelCheck.isElementPresent();
    }

    @Override
    public void clickBuildMuscleGoal() {
        buildMuscleGoal.click();
    }

    @Override
    public boolean getBuildMuscleGoalCheck() {
        return buildMuscleGoalCheck.isElementPresent();
    }

    @Override
    public void typePullup(String pullup) {
        maxPullup.type(pullup);
    }

    @Override
    public void typePushup(String pushup) {
        maxPushup.type(pushup);
    }

    @Override
    public void typeSquat(String squat) {
        maxSquat.type(squat);
    }

    @Override
    public void typeDip(String dip) {
        maxDip.type(dip);
        hideKeyboard();
    }

    @Override
    public void typeUsername(String username) {
        registerUsername.type(username);
    }

    @Override
    public void typeFullName(String fullName) {
        registerFullName.type(fullName);
    }

    @Override
    public void typeEmail(String email) {
        registerEmail.type(email);
    }

    @Override
    public void typePassword(String password) {
        registerPassword.type(password);
        hideKeyboard();
    }

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(nextBtn.getAttribute("enabled"));
    }

    @Override
    public HomePageBase clickLoginBtn() {
        if(isLoginBtnActive()) {
            nextBtn.click();
        }
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public HomePageBase login(int startXValue, int startYValue, int endXValue, int endYValue, int duration,
                              String pullup, String pushup, String squat, String dip, String username, String fullName, String email, String password) {
        selectFemaleSex();
        clickNextBtn();

        clickCmHeightPicker();
        swipeFor164Height(startXValue, startYValue, endXValue, endYValue, duration);
        clickNextBtn();

        clickKgWeightPicker();
        swipeFor64Weight(startXValue, startYValue, endXValue, endYValue, duration);
        clickNextBtn();

        clickFitnessBeginnerLevel();
        if(getFitnessBeginnerLevelCheck()){
            clickNextBtn();
        }

        clickBuildMuscleGoal();
        if(getBuildMuscleGoalCheck()){
            clickNextBtn();
        }

        typePullup(pullup);
        typePushup(pushup);
        typeSquat(squat);
        typeDip(dip);
        clickNextBtn();

        typeUsername(username);
        typeFullName(fullName);
        typeEmail(email);
        typePassword(password);

        return clickLoginBtn();
    }
}
