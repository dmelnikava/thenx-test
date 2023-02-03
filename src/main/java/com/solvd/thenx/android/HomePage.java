package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/home_profile")
    private ExtendedWebElement profileBtn;

    @FindBy(id = "com.sysops.thenx:id/dashboard_header_see_all")
    private ExtendedWebElement viewAllWorkoutsBtn;

    @ExtendedFindBy(text = "No Equipment Home Beginner Program")
    private ExtendedWebElement noEquipmentWorkout;

    @ExtendedFindBy(text = "Shop equipment")
    private ExtendedWebElement shopEquipmentBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return profileBtn.isElementPresent();
    }

    @Override
    public ProfilePageBase openProfilePage() {
        profileBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }

    @Override
    public GuidedWorkoutsPageBase openGuidedWorkoutsPage() {
        viewAllWorkoutsBtn.click();
        return initPage(getDriver(), GuidedWorkoutsPageBase.class);
    }

    @Override
    public void swipePageDown(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
    }

    @Override
    public void doubleSwipePageDown(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
    }

    @Override
    public void swipeToNoEquipmentWorkout(int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
        swipe(startXValue, startYValue, endXValue, endYValue, duration);
    }

    @Override
    public NoEquipmentWorkoutPageBase openNoEquipmentWorkoutPage() {
        noEquipmentWorkout.click();
        return initPage(getDriver(), NoEquipmentWorkoutPageBase.class);
    }

    @Override
    public ShopEquipmentPageBase clickShowEquipmentBtn() {
        shopEquipmentBtn.click();
        return initPage(getDriver(), ShopEquipmentPageBase.class);
    }
}