package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class UsersSearchPageBase extends AbstractPage {

    public UsersSearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract void typeUsername(String username);

    public abstract List<String> getUserNames();

}