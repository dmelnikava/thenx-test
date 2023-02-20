package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.NoEquipmentWeek1PageBase;
import com.solvd.thenx.common.NoEquipmentWeek1UpperBodyPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NoEquipmentWeek1PageBase.class)
public class NoEquipmentWeek1Page extends NoEquipmentWeek1PageBase implements IMobileUtils {

    @ExtendedFindBy(text = "Upper Body")
    private ExtendedWebElement upperBodyWorkout;

    public NoEquipmentWeek1Page(WebDriver driver) {
        super(driver);
    }

    @Override
    public NoEquipmentWeek1UpperBodyPageBase openUpperBodyWorkout() {
        upperBodyWorkout.click();
        return initPage(getDriver(), NoEquipmentWeek1UpperBodyPageBase.class);
    }
}