package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.BlockedUsersPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BlockedUsersPageBase.class)
public class BlockedUsersPage extends BlockedUsersPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/blocked_users_toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(id = "com.sysops.thenx:id/user_name")
    private ExtendedWebElement userName;

    public BlockedUsersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }

    @Override
    public String getUserName() {
        return userName.getText();
    }
}