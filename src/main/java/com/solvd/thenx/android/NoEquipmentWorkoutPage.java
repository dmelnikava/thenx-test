package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.NoEquipmentWeek1PageBase;
import com.solvd.thenx.common.NoEquipmentWorkoutPageBase;
import com.solvd.thenx.common.ProfilePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NoEquipmentWorkoutPageBase.class)
public class NoEquipmentWorkoutPage extends NoEquipmentWorkoutPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/program_parts_title")
    private ExtendedWebElement title;

    @ExtendedFindBy(text = "Week 1")
    private ExtendedWebElement firstWeekWorkout;

    public NoEquipmentWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public NoEquipmentWeek1PageBase openFirstWeek() {
        firstWeekWorkout.click();
        return initPage(getDriver(), NoEquipmentWeek1PageBase.class);
    }
}