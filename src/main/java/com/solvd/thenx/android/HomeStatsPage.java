package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.HomeStatsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomeStatsPageBase.class)
public class HomeStatsPage extends HomeStatsPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/liked_workouts_toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(id = "com.sysops.thenx:id/item_daily_workout_horizontal_text")
    private ExtendedWebElement workoutTitle;

    public HomeStatsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }

    @Override
    public String getWorkoutTitle() {
        return workoutTitle.getText();
    }
}