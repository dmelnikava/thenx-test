package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.FeedPageBase;
import com.solvd.thenx.common.ProfilePageBase;
import com.solvd.thenx.common.UsersSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FeedPageBase.class)
public class FeedPage extends FeedPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "Feed")
    private ExtendedWebElement feedBtn;

    @FindBy(id = "com.sysops.thenx:id/feed_notification_search")
    private ExtendedWebElement searchIcon;

    @FindBy(id = "com.sysops.thenx:id/activity_post_name")
    private List<ExtendedWebElement> activityPostName;

    @FindBy(id = "com.sysops.thenx:id/activity_post_options")
    private List<ExtendedWebElement> activityPostOption;

    @ExtendedFindBy(text = "Block user")
    private ExtendedWebElement blockUserBtn;

    @FindBy(id = "com.sysops.thenx:id/home_profile")
    private ExtendedWebElement profileBtn;

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

    @Override
    public String getActivityPostName() {
        return activityPostName.get(0).getText();
    }

    @Override
    public void clickActivityPostOption() {
        activityPostOption.get(0).click();
    }

    @Override
    public void clickBlockUserBtn() {
        blockUserBtn.click();
    }

    @Override
    public ProfilePageBase openProfilePage() {
        profileBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }
}