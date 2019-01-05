package com.sanjeev.androidtest;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private String text = "Sample";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void userInputTestSenario(){
        //input
        Espresso.onView(withId(R.id.etText)).perform(typeText(text));
        //close softkey
        Espresso.closeSoftKeyboard();
        //performe button click
        Espresso.onView(withId(R.id.btnClick)).perform(click());
        //checking text in text view
        Espresso.onView(withId(R.id.txtChange)).check(matches(withText(text)));
    }

    @After
    public void tearDown() throws Exception {
    }
}