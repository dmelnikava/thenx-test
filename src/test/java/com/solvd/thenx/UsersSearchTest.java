package com.solvd.thenx;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.thenx.common.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsersSearchTest implements IAbstractTest, IMobileUtils {

    @Test(testName = "Check that after searching for a user with the username 'alic', users that contain this username will appear on the screen.")
    public void checkUserNameSearchTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        FeedPageBase feedPage = homePage.openFeedPage();
        UsersSearchPageBase usersSearchPage = feedPage.clickSearchIcon();

        usersSearchPage.typeUsername(R.TESTDATA.get("search_user_name"));

        usersSearchPage.getUserNames()
                .forEach(userName ->softAssert.assertTrue(userName.contains(R.TESTDATA.get("search_user_name")),"User name isn't correct."));
    }
}