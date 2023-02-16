package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FeedPageBase extends AbstractPage {

    public FeedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract UsersSearchPageBase clickSearchIcon();

    public abstract String getActivityPostName();

    public abstract void clickActivityPostOption();

    public abstract void clickBlockUserBtn();

    public abstract ProfilePageBase openProfilePage();

}