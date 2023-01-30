package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NoEquipmentHomeWorkoutPageBase extends AbstractPage {

    public NoEquipmentHomeWorkoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract void openNoEquipmentHomeWorkoutPage();

}