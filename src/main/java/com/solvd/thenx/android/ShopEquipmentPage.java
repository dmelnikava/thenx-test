package com.solvd.thenx.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.thenx.common.ShopEquipmentPageBase;
import com.solvd.thenx.common.WebShopParallettesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShopEquipmentPageBase.class)
public class ShopEquipmentPage extends ShopEquipmentPageBase implements IMobileUtils {

    @FindBy(id = "com.sysops.thenx:id/shop_toolbar")
    private ExtendedWebElement toolbar;

    @ExtendedFindBy(text = "Parallettes")
    private ExtendedWebElement parallettesBtn;

    public ShopEquipmentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }

    @Override
    public WebShopParallettesPageBase clickParallettestBtn() {
        parallettesBtn.click();
        return initPage(getDriver(), WebShopParallettesPageBase.class);
    }
}