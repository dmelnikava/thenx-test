package com.solvd.thenx;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.thenx.common.GuidedWorkoutsPageBase;
import com.solvd.thenx.common.HomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkoutsTest  implements IAbstractTest, IMobileUtils {

    @Test(testName = "Check that names of the first three workouts contains 'Home Leg Workout'.")
    public void verifyWorkoutNamesTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        GuidedWorkoutsPageBase guidedWorkoutsPage = homePage.openGuidedWorkoutsPage();

        softAssert.assertTrue(guidedWorkoutsPage.isPageOpened());
        guidedWorkoutsPage.clickSearchInput();
        guidedWorkoutsPage.typeWorkout(R.TESTDATA.get("workout_name"));
        hideKeyboard();

        guidedWorkoutsPage.getWorkoutNames().forEach(workoutName -> softAssert.assertTrue(workoutName.contains(R.TESTDATA.get("workout_name"))));
    }
}