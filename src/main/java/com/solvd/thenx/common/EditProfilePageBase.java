package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class EditProfilePageBase extends AbstractPage {

    public EditProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract String getUsername();

    public abstract String getEmail();

    public abstract String getFullName();

    public abstract String getGender();

    public abstract String getHeight();

    public abstract String getWeight();

    public abstract String getFitnessLevel();

    public abstract String getGoal();

    public abstract String getMaxPullup();

    public abstract String getMaxPushup();

    public abstract String getMaxSquat();

    public abstract String getMaxDip();

    public abstract void swipePageDown(int startXValue, int startYValue, int endXValue, int endYValue, int duration);

    public abstract ProfilePageBase setUserLocation(String country, String state, String city);

}
