package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NoEquipmentWorkoutPageBase extends AbstractPage {

    public NoEquipmentWorkoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract NoEquipmentWeek1PageBase openFirstWeek();

}