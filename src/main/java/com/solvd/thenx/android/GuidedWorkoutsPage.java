package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.GuidedWorkoutsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GuidedWorkoutsPageBase.class)
public class GuidedWorkoutsPage extends GuidedWorkoutsPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/video_workouts_toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(id = "com.sysops.thenx:id/search_input")
    private ExtendedWebElement searchInput;

    @FindBy(id = "com.sysops.thenx:id/video_workout_text")
    private List<ExtendedWebElement> workoutNames;

    public GuidedWorkoutsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }

    @Override
    public void clickSearchInput() {
        searchInput.click();
    }

    @Override
    public void typeWorkout(String workout) {
        searchInput.type(workout);
    }

    @Override
    public List<String> getWorkoutNames() {
        return workoutNames.stream()
                .map(workoutName -> workoutName.getText())
                .collect(Collectors.toList());
    }
}