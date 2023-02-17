package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.HomePageBase;
import com.solvd.thenx.common.ProfilePageBase;
import com.solvd.thenx.common.WorkoutsLibraryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WorkoutsLibraryPageBase.class)
public class WorkoutsLibraryPage extends WorkoutsLibraryPageBase implements IMobileUtils {

    @ExtendedFindBy(text = "Workouts Library")
    private ExtendedWebElement toolbar;

    @FindBy(id = "com.sysops.thenx:id/view_featured_workout_header_title")
    private ExtendedWebElement workoutOfTheDayTitle;

    @FindBy(id = "com.sysops.thenx:id/daily_workout_likes_icon")
    private ExtendedWebElement workoutLikesIcon;

    @FindBy(id = "com.sysops.thenx:id/thenx_toolbar_back_icon")
    private ExtendedWebElement backIcon;

    public WorkoutsLibraryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }

    @Override
    public String getWorkoutOfTheDayTitle() {
        return workoutOfTheDayTitle.getText();
    }

    @Override
    public void clickWorkoutOfTheDayTitle() {
        workoutOfTheDayTitle.click();
    }

    @Override
    public void clickWorkoutLikesIcon() {
        workoutLikesIcon.click();
    }

    @Override
    public HomePageBase backToHomePage() {
        backIcon.click();
        backIcon.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}