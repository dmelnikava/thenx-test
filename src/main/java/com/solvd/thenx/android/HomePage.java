package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.HomePageBase;
import com.solvd.thenx.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/home_profile")
    private ExtendedWebElement profileBtn;

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
}