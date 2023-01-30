package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.EditProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EditProfilePageBase.class)
public class EditProfilePage extends EditProfilePageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/edit_profile_username")
    private ExtendedWebElement username;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_email")
    private ExtendedWebElement email;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_full_name")
    private ExtendedWebElement fullName;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_gender")
    private ExtendedWebElement gender;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_height")
    private ExtendedWebElement height;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_weight")
    private ExtendedWebElement weight;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_fitness_level")
    private ExtendedWebElement fitnessLevel;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_goals")
    private ExtendedWebElement goal;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_max_pullups")
    private ExtendedWebElement maxPullup;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_max_pushups")
    private ExtendedWebElement maxPushup;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_max_squats")
    private ExtendedWebElement maxSquat;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_max_dips")
    private ExtendedWebElement maxDip;

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return username.isElementPresent();
    }

    @Override
    public String getUsername() {
        return username.getText().toLowerCase();
    }

    @Override
    public String getEmail() {
        return email.getText().toLowerCase();
    }

    @Override
    public String getFullName() {
        return fullName.getText();
    }

    @Override
    public String getGender() {
        return gender.getText();
    }

    @Override
    public String getHeight() {
        return height.getText();
    }

    @Override
    public String getWeight() {
        return weight.getText();
    }

    @Override
    public String getFitnessLevel() {
        return fitnessLevel.getText();
    }

    @Override
    public String getGoal() {
        return goal.getText();
    }

    @Override
    public String getMaxPullup() {
        return maxPullup.getText();
    }

    @Override
    public String getMaxPushup() {
        return maxPushup.getText();
    }

    @Override
    public String getMaxSquat() {
        return maxSquat.getText();
    }

    @Override
    public String getMaxDip() {
        return maxDip.getText();
    }

    @Override
    public void swipePageDown(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        swipe(startXValue,startYValue, endXValue, endYValue, duration);
    }
}