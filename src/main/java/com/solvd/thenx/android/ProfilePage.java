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

    @FindBy(id = "com.sysops.thenx:id/profile_edit_profile")
    private ExtendedWebElement editProfileBtn;

    @FindBy(id = "com.sysops.thenx:id/profile_location")
    private ExtendedWebElement userLocation;

    @FindBy(id = "com.sysops.thenx:id/activity_post_constraint")
    private ExtendedWebElement completedWorkoutPost;

    @FindBy(id = "com.sysops.thenx:id/activity_post_workout_title")
    private ExtendedWebElement postWorkoutTitle;

    @FindBy(id = "com.sysops.thenx:id/activity_post_workout_subtitle")
    private ExtendedWebElement postWorkoutSubtitle;

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

    @Override
    public String getUserLocation() {
        return userLocation.getText();
    }

    @Override
    public boolean isPostPresent() {
        return completedWorkoutPost.isElementPresent();
    }

    @Override
    public String getPostWorkoutTitle() {
        return postWorkoutTitle.getText();
    }

    @Override
    public String getPostWorkoutSubtitle() {
        return postWorkoutSubtitle.getText();
    }
}