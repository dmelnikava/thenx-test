package com.solvd.thenx.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ShopEquipmentPageBase extends AbstractPage {

    public ShopEquipmentPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebShopParallettesPageBase clickParallettestBtn();

}