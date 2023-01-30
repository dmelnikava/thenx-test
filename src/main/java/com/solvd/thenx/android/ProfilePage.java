package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.EditProfilePageBase;
import com.solvd.thenx.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase implements IMobileUtils {

    @FindBy(id ="com.sysops.thenx:id/profile_edit_profile")
    private ExtendedWebElement editProfileBtn;

    @FindBy(id = "com.sysops.thenx:id/profile_location")
    private ExtendedWebElement userLocation;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return editProfileBtn.isElementPresent();
    }

    @Override
    public EditProfilePageBase openEditProfilePage() {
        editProfileBtn.click();
        return initPage(getDriver(), EditProfilePageBase.class);
    }

    public String getUserLocation() {
        return userLocation.getText();
    }
}