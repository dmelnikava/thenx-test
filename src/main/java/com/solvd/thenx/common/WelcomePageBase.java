package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract OnBoardingPageBase openOnBoardingPage();

}
