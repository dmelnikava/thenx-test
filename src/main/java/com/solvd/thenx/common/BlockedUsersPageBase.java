package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BlockedUsersPageBase extends AbstractPage {

    public BlockedUsersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();


    public abstract String getUserName();

}