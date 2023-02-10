package com.solvd.thenx;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.thenx.common.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTest implements IAbstractTest, IMobileUtils {

    @Test(testName = "Verify that the user location is 'Columbus, Ohio, United States' by setting it in profile.")
    public void verifySetUserLocationTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProfilePageBase profilePage = homePage.openProfilePage();
        EditProfilePageBase editProfilePage = profilePage.openEditProfilePage();

        ProfilePageBase changedProfilePage = editProfilePage.setUserLocation(R.TESTDATA.get("user_country"), R.TESTDATA.get("user_state"), R.TESTDATA.get("user_city"));

        Assert.assertEquals(changedProfilePage.getUserLocation(), "Columbus, Ohio, United States", "User location isn't set up correctly.");
    }

    @Test(testName = "Check that the welcome page opens when the user logs out from the profile.")
    public void checkUserLogoutTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProfilePageBase profilePage = homePage.openProfilePage();
        EditProfilePageBase editProfilePage = profilePage.openEditProfilePage();

        editProfilePage.swipePageDownToLogoutBtn(Integer.parseInt(R.TESTDATA.get("startXValue")), Integer.parseInt(R.TESTDATA.get("startYValue")), Integer.parseInt(R.TESTDATA.get("endXValue")), Integer.parseInt(R.TESTDATA.get("endYValue")),
                Integer.parseInt(R.TESTDATA.get("duration")));

        WelcomePageBase welcomePage = editProfilePage.clickLogoutBtn();

        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened.");
    }
}