package com.example.zhaogaofei.androidtest;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class RecycleViewActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test() {
        // 点击进入RecyclerTest测试页面
        onView(withId(R.id.button_two)).perform(click());

        onView(withText("item position: 0")).check(matches(isDisplayed())).perform(click());

        onView(withText("确定")).perform(click());

        // onView(withText("item position: 2")).check(matches(isDisplayed())).perform(click());

        pressBack();

        onView(withText("recycle 测试")).perform(click());

        onView(withId(R.id.recycler_view_test)).perform(scrollToPosition(21));

        onView(withText("item position: 20")).check(matches(isDisplayed())).perform(click());

        onView(withText("取消")).perform(click());

        pressBack();
    }

    @Test
    public void test2() {
        onView(withId(R.id.button_two)).perform(click());

        onView(withText("item position: 0")).check(matches(isDisplayed())).perform(click());

        // pressBack();

        // onView(withId(R.id.recycler_view_test)).check(matches(isDisplayed())).perform(scrollTo(withText("item position: 2")));

        onView(withId(R.id.recycler_view_test)).perform(scrollToPosition(21));

        onView(withId(R.id.recycler_view_test)).perform(scrollToPosition(2));

        onView(withId(R.id.recycler_view_test)).perform(scrollToPosition(18));

        // onView(withText("item position: 2")).check(matches(isDisplayed())).perform(click());
    }
}
