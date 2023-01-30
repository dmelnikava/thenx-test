package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract EditProfilePageBase openEditProfilePage();

    public abstract String getUserLocation();

}