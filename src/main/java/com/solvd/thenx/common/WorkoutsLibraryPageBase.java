package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WorkoutsLibraryPageBase extends AbstractPage {

    public WorkoutsLibraryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract String getWorkoutOfTheDayTitle();

    public abstract void clickWorkoutOfTheDayTitle();

    public abstract void clickWorkoutLikesIcon();

    public abstract HomePageBase backToHomePage();

}