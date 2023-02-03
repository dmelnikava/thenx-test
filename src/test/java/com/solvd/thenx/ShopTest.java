package com.solvd.thenx;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.thenx.common.HomePageBase;
import com.solvd.thenx.common.ShopEquipmentPageBase;
import com.solvd.thenx.common.WebShopParallettesPageBase;
import com.solvd.thenx.utils.MobileContextUtils;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShopTest implements IAbstractTest, IMobileUtils {

    @Test(testName = "Check that after clicking on parallettes in the equipment shop webpage with parallettes is opened.")
    public void checkParallettesWebpageIsOpenedTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.doubleSwipePageDown(Integer.parseInt(R.TESTDATA.get("startXValue")), Integer.parseInt(R.TESTDATA.get("startYValue")), Integer.parseInt(R.TESTDATA.get("endXValue")),
                Integer.parseInt(R.TESTDATA.get("endYValue")), Integer.parseInt(R.TESTDATA.get("duration")));

        ShopEquipmentPageBase shopEquipmentPage = homePage.clickShowEquipmentBtn();

        WebShopParallettesPageBase webShopParallettesPage = shopEquipmentPage.clickParallettestBtn();

        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.WEB);

        softAssert.assertTrue(webShopParallettesPage.isPageOpened(), "Shop parallettes webpage isn't opened.");

        softAssert.assertEquals(getDriver().getCurrentUrl(), "https://shop.thenx.com/collections/equipment/products/thenx-parallettes",
                "Current url isn't correct.");
    }
}