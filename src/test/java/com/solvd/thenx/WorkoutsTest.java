package com.solvd.thenx;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.thenx.common.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkoutsTest implements IAbstractTest, IMobileUtils {

    @Test(testName = "Verify that names of the first three workouts contains 'Home Leg Workout'.")
    public void verifyWorkoutNamesTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        GuidedWorkoutsPageBase guidedWorkoutsPage = homePage.openGuidedWorkoutsPage();

        softAssert.assertTrue(guidedWorkoutsPage.isPageOpened(), "Guided Workouts page isn't opened.");

        guidedWorkoutsPage.clickSearchInput();
        guidedWorkoutsPage.typeWorkout(R.TESTDATA.get("workout_name"));
        hideKeyboard();

        guidedWorkoutsPage.getWorkoutNames().forEach(workoutName -> softAssert.assertTrue(workoutName.contains(R.TESTDATA.get("workout_name")), "Workout name isn't correct."));
    }

    @Test(testName = "Check that upper body 1 week workout of no equipment home program is saved to the user's profile by closing workout without completing any exercise.")
    public void checkSavingUserWorkoutWithoutCompletingAnyExerciseTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.swipePageDown(Integer.parseInt(R.TESTDATA.get("startXValue")), Integer.parseInt(R.TESTDATA.get("startYValue")), Integer.parseInt(R.TESTDATA.get("endXValue")),
                Integer.parseInt(R.TESTDATA.get("endYValue")), Integer.parseInt(R.TESTDATA.get("duration")));
        homePage.swipeToNoEquipmentWorkout(Integer.parseInt(R.TESTDATA.get("swipeToLeftStartXValue")), Integer.parseInt(R.TESTDATA.get("swipeToLeftStartYValue")), Integer.parseInt(R.TESTDATA.get("swipeToLeftEndXValue")),
                Integer.parseInt(R.TESTDATA.get("swipeToLeftEndYValue")), Integer.parseInt(R.TESTDATA.get("swipeToLeftDuration")));
        NoEquipmentWorkoutPageBase noEquipmentWorkoutPage = homePage.openNoEquipmentWorkoutPage();

        softAssert.assertTrue(noEquipmentWorkoutPage.isPageOpened(), "No Equipment Workout page isn't opened.");

        noEquipmentWorkoutPage.openFirstWeek();
        noEquipmentWorkoutPage.openUpperBodyWorkout();
        noEquipmentWorkoutPage.startWorkout();
        noEquipmentWorkoutPage.swipeWarmUp(Integer.parseInt(R.TESTDATA.get("swipeWarmUpStartXValue")), Integer.parseInt(R.TESTDATA.get("swipeWarmUpStartYValue")), Integer.parseInt(R.TESTDATA.get("swipeWarmUpEndXValue")),
                Integer.parseInt(R.TESTDATA.get("swipeWarmUpEndYValue")), Integer.parseInt(R.TESTDATA.get("swipeWarmUpDuration")));
        noEquipmentWorkoutPage.closeWorkoutSession();
        noEquipmentWorkoutPage.finishWorkout();

        ProfilePageBase profilePage = noEquipmentWorkoutPage.clickSaveWorkoutBtn();

        softAssert.assertTrue(profilePage.isPostPresent(), "Workout post isn't saved.");
        softAssert.assertEquals("Upper Body", profilePage.getPostWorkoutTitle(), "Workout post title isn't correct.");
        softAssert.assertEquals("No Equipment Home Beginner Program", profilePage.getPostWorkoutSubtitle(), "Workout post subtitle isn't correct.");
    }

    @Test(testName = "Check the preservation of the liked workout of the day to the home stats.")
    public void checkPreservationOfTheLikedWorkoutOfTheDayTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        WorkoutsLibraryPageBase workoutsLibraryPage = homePage.openWorkoutsLibrary();

        String workoutOfTheDayTitle = workoutsLibraryPage.getWorkoutOfTheDayTitle();
        workoutsLibraryPage.clickWorkoutOfTheDayTitle();
        workoutsLibraryPage.clickWorkoutLikesIcon();
        HomePageBase returnedHomePage = workoutsLibraryPage.backToHomePage();

        HomeStatsPageBase homeStatsPage = returnedHomePage.openHomeStatsPage();

        Assert.assertEquals(workoutOfTheDayTitle, homeStatsPage.getWorkoutTitle(), "Workout of the day was not licked.");
    }
}