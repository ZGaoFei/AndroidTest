package com.example.zhaogaofei.androidtest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private static final String CLICK_TEXT_TEST = "click index: ";
    private int index = 0;

    @Test
    public void testContext() {
        Context targetContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.zhaogaofei.androidtest", targetContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> mTasksActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testClick() {
        // 获取view
        ViewInteraction view = onView(withId(R.id.text_view));
        // 测试点击
        view.perform(click());

        // 测试setText()
        // index++;
        // view.perform(typeText(CLICK_TEXT_TEST + index));

        // view.perform(replaceText(CLICK_TEXT_TEST + index));

        view.check(matches(withText("Main activity test!!!")));
    }

    @Test
    public void testButton() {
        onView(withId(R.id.button_one)).perform(click());

        onView(withId(R.id.button_one)).check(matches(not(isDisplayed())));

        MainActivity activity = mTasksActivityTestRule.getActivity();

    }

    @Test
    public void testButtonClick() {
        for (int i = 0; i < 20; i++) {
            onView(withId(R.id.button_one)).perform(click());
        }
    }

}
