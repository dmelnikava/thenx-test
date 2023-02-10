package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.thenx.common.UsersSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UsersSearchPageBase.class)
public class UsersSearchPage extends UsersSearchPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/search_users_toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(id = "com.sysops.thenx:id/search_input")
    private ExtendedWebElement searchInput;

    @FindBy(id = "com.sysops.thenx:id/user_name")
    private List<ExtendedWebElement> userNames;

    public UsersSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }

    @Override
    public void typeUsername(String username) {
        searchInput.type(username);
    }

    @Override
    public List<String> getUserNames() {
        return userNames.stream()
                .map(userName -> userName.getText())
                .collect(Collectors.toList());
    }
}