package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.ConfirmDeleteAccountPageBase;
import com.solvd.thenx.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ConfirmDeleteAccountPageBase.class)
public class ConfirmDeleteAccountPage extends ConfirmDeleteAccountPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/cancel_title")
    private ExtendedWebElement title;

    @ExtendedFindBy(text = "Other")
    private ExtendedWebElement otherCheckbox;

    @FindBy(id = "com.sysops.thenx:id/cancel_feedback")
    private ExtendedWebElement feedbackSection;

    @FindBy(id = "com.sysops.thenx:id/cancel_subscription_button")
    private ExtendedWebElement deleteAccountBtn;

    public ConfirmDeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public ConfirmDeleteAccountPage clickOtherCheckbox() {
        otherCheckbox.click();
        return this;
    }

    @Override
    public ConfirmDeleteAccountPage typeFeedback(String feedback) {
        feedbackSection.type(feedback);
        return this;
    }

    @Override
    public WelcomePageBase clickDeleteAccountBtn() {
        deleteAccountBtn.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }
}