package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract ProfilePageBase openProfilePage();

    public abstract GuidedWorkoutsPageBase openGuidedWorkoutsPage();

    public abstract void swipePageDown(int startXValue, int startYValue, int endXValue, int endYValue, int duration);

    public abstract void swipeToNoEquipmentWorkout(int startXValue, int startYValue, int endXValue, int endYValue, int duration);

    public abstract NoEquipmentWorkoutPageBase openNoEquipmentWorkoutPage();

}