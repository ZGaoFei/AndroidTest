package com.example.zhaogaofei.androidtest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EditTextActivityTest {

    @Rule
    public ActivityTestRule<EditTextActivity> rule = new ActivityTestRule<>(EditTextActivity.class);

    @Test
    public void testInput() {
        onView(withId(R.id.et_one)).perform(typeText("10"), closeSoftKeyboard());

        onView(withId(R.id.et_two)).perform(typeText("20"), closeSoftKeyboard());

        onView(withId(R.id.bt_sum)).perform(click());

        onView(withId(R.id.tv_sum)).check(matches(withText("30.0")));

        onView(withId(R.id.tv_sum)).check(matches(withText("31")));
    }

    @Test
    public void testInput2() {
        onView(withId(R.id.et_one)).perform(typeText("10"), closeSoftKeyboard());

        onView(withId(R.id.et_two)).perform(typeText("20"), closeSoftKeyboard());

        // 使用布局上面的文案来查找布局，文案必须唯一，如果多个相同文案，会报错
        onView(withText("求和")).perform(click());

        onView(withText("30.0")).check(matches(withText("30.0")));

        onView(withText("求积")).perform(click());

        onView(withId(R.id.tv_sum)).check(matches(withText("200")));
    }
}
