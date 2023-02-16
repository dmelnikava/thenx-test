package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.BlockedUsersPageBase;
import com.solvd.thenx.common.EditProfilePageBase;
import com.solvd.thenx.common.ProfilePageBase;
import com.solvd.thenx.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EditProfilePageBase.class)
public class EditProfilePage extends EditProfilePageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/edit_profile_toolbar")
    private ExtendedWebElement toolbar;

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

    @FindBy(id = "com.sysops.thenx:id/edit_profile_country")
    private ExtendedWebElement userCountry;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_state")
    private ExtendedWebElement userState;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_city")
    private ExtendedWebElement userCity;

    @FindBy(id = "com.sysops.thenx:id/country_code_picker_search")
    private ExtendedWebElement countrySearcher;

    @FindBy(id = "com.sysops.thenx:id/country_title")
    private ExtendedWebElement countryTitle;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_save")
    private ExtendedWebElement saveSettingsBtn;

    @FindBy(id = "com.sysops.thenx:id/thenx_toolbar_back_icon")
    private ExtendedWebElement backIcon;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_logout")
    private ExtendedWebElement logoutBtn;

    @FindBy(id = "com.sysops.thenx:id/edit_profile_blocked_users")
    private ExtendedWebElement blockedUsersBtn;

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
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
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
    }

    @Override
    public void swipePageDownToLogoutBtn(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
    }

    @Override
    public void clickUserCountry() {
        userCountry.click();
    }

    @Override
    public void typeCountry(String country) {
        countrySearcher.type(country);
    }

    @Override
    public void clickCountryTitle() {
        countryTitle.click();
    }

    @Override
    public void clickUserState() {
        userState.click();
    }

    @Override
    public void typeState(String state) {
        userState.type(state);
    }

    @Override
    public void clickUserCity() {
        userCity.click();
    }

    @Override
    public void typeCity(String city) {
        userCity.type(city);
    }

    @Override
    public void clickSaveSettingsBtn() {
        saveSettingsBtn.click();
    }

    @Override
    public ProfilePageBase clickBackIcon() {
        backIcon.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }

    @Override
    public ProfilePageBase setUserLocation(String country, String state, String city) {
        clickUserCountry();
        typeCountry(country);
        clickCountryTitle();

        clickUserState();
        typeState(state);

        clickUserCity();
        typeCity(city);

        clickSaveSettingsBtn();

        return clickBackIcon();
    }

    @Override
    public WelcomePageBase clickLogoutBtn() {
        logoutBtn.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }

    @Override
    public BlockedUsersPageBase clickBlockedUsersBtn() {
        blockedUsersBtn.click();
        return initPage(getDriver(), BlockedUsersPageBase.class);
    }
}