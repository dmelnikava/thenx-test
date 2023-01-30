package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.OnBoardingPageBase;
import com.solvd.thenx.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/authentication_create_account")
    private ExtendedWebElement createAccountBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return createAccountBtn.isElementPresent();
    }

    @Override
    public OnBoardingPageBase openOnBoardingPage() {
        createAccountBtn.click();
        return initPage(getDriver(), OnBoardingPageBase.class);
    }
}