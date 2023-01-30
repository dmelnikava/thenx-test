package com.solvd.thenx;

import com.solvd.thenx.common.*;
import com.solvd.thenx.utils.ValueGeneratorService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.asserts.SoftAssert;

public class RegistrationTest implements IAbstractTest, IMobileUtils {

    @DataProvider(name = "Swipe data to get user's data")
    public static Object[][] registrationSwipeDataProvider() {
        return new Object[][]{
                {550, 1340, 550, 1670, 500, 550, 1900, 550, 900, 500}
        };
    }

    @Test(testName = "Check user's registration with unregistered email and username", dataProvider = "Swipe data to get user's data")
    public void checkUserRegistrationTest(int registrationStartXValue, int registrationStartYValue, int registrationEndXValue, int registrationEndYValue, int registrationDuration,
                                                                       int startXValue, int startYValue, int endXValue, int endYValue, int duration) {
        SoftAssert softAssert = new SoftAssert();

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        OnBoardingPageBase onBoardingPage = welcomePage.openOnBoardingPage();

        String pullup =  ValueGeneratorService.generateNumericString(2);
        String pushup = ValueGeneratorService.generateNumericString(2);
        String squat = ValueGeneratorService.generateNumericString(2);
        String dip = ValueGeneratorService.generateNumericString(2);
        String username = ValueGeneratorService.generateAlphabeticString(10);
        String fullName = ValueGeneratorService.generateAlphabeticString(10);
        String email = ValueGeneratorService.generateAlphabeticString(10) + "@gmail.com";
        String password = ValueGeneratorService.generateAlphabeticString(10);

        HomePageBase homePage = onBoardingPage.login(registrationStartXValue, registrationStartYValue, registrationEndXValue, registrationEndYValue, registrationDuration, pullup, pushup, squat, dip, username, fullName, email, password);
        softAssert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        ProfilePageBase profilePage = homePage.openProfilePage();
        EditProfilePageBase editProfilePage = profilePage.openEditProfilePage();

        softAssert.assertTrue(username.toLowerCase().equals(editProfilePage.getUsername()), "Username data isn't correct");
        softAssert.assertTrue(email.toLowerCase().equals(editProfilePage.getEmail()), "Email data isn't correct");
        softAssert.assertTrue(fullName.equals(editProfilePage.getFullName()), "Full name data isn't correct");
        softAssert.assertTrue("Female".equals(editProfilePage.getGender()), "User's gender isn't correct");
        softAssert.assertTrue("164 centimeters".equals(editProfilePage.getHeight()), "User's height isn't  correct");
        softAssert.assertTrue("64 kilograms".equals(editProfilePage.getWeight()), "User's weight isn't  correct");

        editProfilePage.swipePageDown(startXValue, startYValue, endXValue, endYValue, duration);

        softAssert.assertTrue("Beginner".equals(editProfilePage.getFitnessLevel()), "User's fitness level isn't  correct");
        softAssert.assertTrue("Build Muscle".equals(editProfilePage.getGoal()), "User's goal isn't  correct");
        softAssert.assertTrue(pullup.equals(editProfilePage.getMaxPullup()), "Pullup data isn't correct");
        softAssert.assertTrue(pushup.equals(editProfilePage.getMaxPushup()), "Pushup data isn't correct");
        softAssert.assertTrue(squat.equals(editProfilePage.getMaxSquat()), "Squat data isn't correct");
        softAssert.assertTrue(dip.equals(editProfilePage.getMaxDip()), "Dip data isn't correct");

        softAssert.assertAll();
    }
}