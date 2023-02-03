package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.NoEquipmentWorkoutPageBase;
import com.solvd.thenx.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NoEquipmentWorkoutPageBase.class)
public class NoEquipmentWorkoutPage extends NoEquipmentWorkoutPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/program_parts_title")
    private ExtendedWebElement title;

    @ExtendedFindBy(text = "Week 1")
    private ExtendedWebElement firstWeekWorkout;

    @ExtendedFindBy(text = "Upper Body")
    private ExtendedWebElement upperBodyWorkout;

    @FindBy(id = "com.sysops.thenx:id/workout_details_start")
    private ExtendedWebElement startWorkoutBtn;

    @FindBy(id = "com.sysops.thenx:id/warmup_exercise_list_recyclerview")
    private ExtendedWebElement warmupExercise;

    @FindBy(id = "com.sysops.thenx:id/workout_session_close")
    private ExtendedWebElement sessionCloseBtn;

    @FindBy(id = "com.sysops.thenx:id/exit_workout_finish")
    private ExtendedWebElement workoutFinishBtn;

    @FindBy(id = "com.sysops.thenx:id/share_workout_post")
    private ExtendedWebElement saveWorkoutBtn;

    @ExtendedFindBy(image = "")
    private ExtendedWebElement a;

    public NoEquipmentWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public void openFirstWeek() {
        firstWeekWorkout.click();
    }

    @Override
    public void openUpperBodyWorkout() {
        upperBodyWorkout.click();
    }

    @Override
    public void startWorkout() {
        startWorkoutBtn.click();
    }

    @Override
    public void swipeWarmUp(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        if (warmupExercise.isElementPresent()) {
            swipe(startXValue, startYValue, endXValue, endYValue, duration);
        }
    }

    @Override
    public void closeWorkoutSession() {
        sessionCloseBtn.click();
    }

    @Override
    public void finishWorkout() {
        workoutFinishBtn.click();
    }

    @Override
    public ProfilePageBase clickSaveWorkoutBtn() {
        saveWorkoutBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }
}