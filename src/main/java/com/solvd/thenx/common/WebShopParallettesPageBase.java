package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebShopParallettesPageBase extends AbstractPage {

    public WebShopParallettesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

}