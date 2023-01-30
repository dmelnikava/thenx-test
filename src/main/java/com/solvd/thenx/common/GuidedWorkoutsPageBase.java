package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class GuidedWorkoutsPageBase extends AbstractPage {

    public GuidedWorkoutsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract void clickSearchInput();

    public abstract void typeWorkout(String workout);

    public abstract List<String> getWorkoutNames();

}