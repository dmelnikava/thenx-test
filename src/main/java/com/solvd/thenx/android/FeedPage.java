package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.FeedPageBase;
import com.solvd.thenx.common.UsersSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FeedPageBase.class)
public class FeedPage extends FeedPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "Feed")
    private ExtendedWebElement feedBtn;

    @FindBy(id = "com.sysops.thenx:id/feed_notification_search")
    private ExtendedWebElement searchIcon;

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return feedBtn.isElementPresent();
    }

    @Override
    public UsersSearchPageBase clickSearchIcon() {
        searchIcon.click();
        return initPage(getDriver(), UsersSearchPageBase.class);
    }
}