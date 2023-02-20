package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NoEquipmentWeek1UpperBodyPageBase extends AbstractPage {

    public NoEquipmentWeek1UpperBodyPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void startWorkout();

    public abstract void swipeWarmUp(int startXValue, int startYValue, int endXValue, int endYValue, int duration);

    public abstract void closeWorkoutSession();

    public abstract void finishWorkout();

    public abstract ProfilePageBase clickSaveWorkoutBtn();
}