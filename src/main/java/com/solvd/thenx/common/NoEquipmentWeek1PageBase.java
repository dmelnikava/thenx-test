package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NoEquipmentWeek1PageBase extends AbstractPage {

    public NoEquipmentWeek1PageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NoEquipmentWeek1UpperBodyPageBase openUpperBodyWorkout();

}
