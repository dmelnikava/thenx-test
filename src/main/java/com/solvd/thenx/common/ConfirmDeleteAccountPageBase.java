package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.thenx.android.ConfirmDeleteAccountPage;
import org.openqa.selenium.WebDriver;

public abstract class ConfirmDeleteAccountPageBase extends AbstractPage {

    public ConfirmDeleteAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract ConfirmDeleteAccountPage clickOtherCheckbox();

    public abstract ConfirmDeleteAccountPage typeFeedback(String feedback);

    public abstract WelcomePageBase clickDeleteAccountBtn();

}