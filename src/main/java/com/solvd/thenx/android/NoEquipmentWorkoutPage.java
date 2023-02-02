package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.NoEquipmentHomeWorkoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NoEquipmentHomeWorkoutPageBase.class)
public class NoEquipmentHomeWorkoutPage extends NoEquipmentHomeWorkoutPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/program_parts_title")
    private ExtendedWebElement title;

    @ExtendedFindBy(text = "Week 1")
    private ExtendedWebElement firstWeekWorkout;

    @ExtendedFindBy(text = "Upper Body")
    private ExtendedWebElement upperBodyFirstWeekWorkout;

    @FindBy(id = "com.sysops.thenx:id/workout_details_start")
    private ExtendedWebElement startBtn;

    public NoEquipmentHomeWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public void openNoEquipmentHomeWorkoutPage() {
        firstWeekWorkout.click();
    }
}