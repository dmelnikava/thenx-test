package com.solvd.thenx;

import com.solvd.thenx.common.*;
import com.solvd.thenx.utils.ValueGeneratorService;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.asserts.SoftAssert;

public class RegistrationTest implements IAbstractTest, IMobileUtils {

    @Test(testName = "Check user's registration with random email and username.")
    public void checkUserRegistrationTest() {
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

        HomePageBase homePage = onBoardingPage.login(Integer.parseInt(R.TESTDATA.get("registrationStartXValue")), Integer.parseInt(R.TESTDATA.get("registrationStartYValue")), Integer.parseInt(R.TESTDATA.get("registrationEndXValue")),
                Integer.parseInt(R.TESTDATA.get("registrationEndYValue")), Integer.parseInt(R.TESTDATA.get("registrationDuration")), pullup, pushup, squat, dip, username, fullName, email, password);
        softAssert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");

        ProfilePageBase profilePage = homePage.openProfilePage();
        EditProfilePageBase editProfilePage = profilePage.openEditProfilePage();

        softAssert.assertTrue(username.toLowerCase().equals(editProfilePage.getUsername()), "Username data isn't correct.");
        softAssert.assertTrue(email.toLowerCase().equals(editProfilePage.getEmail()), "Email data isn't correct.");
        softAssert.assertTrue(fullName.equals(editProfilePage.getFullName()), "Full name data isn't correct.");
        softAssert.assertTrue("Female".equals(editProfilePage.getGender()), "User's gender isn't correct.");
        softAssert.assertTrue("164 centimeters".equals(editProfilePage.getHeight()), "User's height isn't  correct.");
        softAssert.assertTrue("64 kilograms".equals(editProfilePage.getWeight()), "User's weight isn't  correct.");

        editProfilePage.swipePageDown(Integer.parseInt(R.TESTDATA.get("startXValue")), Integer.parseInt(R.TESTDATA.get("startYValue")), Integer.parseInt(R.TESTDATA.get("endXValue")), Integer.parseInt(R.TESTDATA.get("endYValue")),
                Integer.parseInt(R.TESTDATA.get("duration")));

        softAssert.assertTrue("Beginner".equals(editProfilePage.getFitnessLevel()), "User's fitness level isn't  correct.");
        softAssert.assertTrue("Build Muscle".equals(editProfilePage.getGoal()), "User's goal isn't  correct.");
        softAssert.assertTrue(pullup.contains(editProfilePage.getMaxPullup()), "Pullup data isn't correct.");
        softAssert.assertTrue(pushup.contains(editProfilePage.getMaxPushup()), "Pushup data isn't correct.");
        softAssert.assertTrue(squat.contains(editProfilePage.getMaxSquat()), "Squat data isn't correct.");
        softAssert.assertTrue(dip.contains(editProfilePage.getMaxDip()), "Dip data isn't correct.");

        softAssert.assertAll();
    }
}