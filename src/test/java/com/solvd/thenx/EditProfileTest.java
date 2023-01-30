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
}